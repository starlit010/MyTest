package com.grayliu.nio;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by liuhui-ds9 on 2018/10/23.
 */
@Slf4j
@NoArgsConstructor
public class HttpHandler implements Runnable {

    int buffersize = 1024;

    private String localCharSet="UTF-8"; //设置编码格式

    SelectionKey selectionKey = null;

    public HttpHandler(SelectionKey selectionKey){
        this.selectionKey = selectionKey;
    }

    @Override
    public void run(){
        if(!ObjectUtils.allNotNull(selectionKey)){
            return;
        }

        try{
            if(selectionKey.isAcceptable()){
                handleAccepte(selectionKey);
            }

            if(selectionKey.isReadable()){
                handleReadable(selectionKey);
            }
        }catch(IOException ioe){

        }
    }

    private void handleAccepte(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = ((ServerSocketChannel)selectionKey.channel()).accept();
        socketChannel.configureBlocking(false);//设置非阻塞模式
        socketChannel.register(selectionKey.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(buffersize));
    }

    private void handleReadable(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
        ByteBuffer buffer = (ByteBuffer)selectionKey.attachment();
        buffer.clear();

        if((socketChannel.read(buffer))!=-1) {

            buffer.flip();//flip方法将Buffer从写模式切换到读模式

            String receive = Charset.forName(localCharSet).newDecoder().decode(buffer).toString();

            String[] requestMessage = receive.split("\r\n");//接受请求的信息

            for (String message : requestMessage) {

                if (message.isEmpty()) {//如果是空行说明信息已经结束了

                    break;
                }
            }

            String[] firsetLine = requestMessage[0].split(" ");

            log.info("----控制台输出：-------");

            log.info("Method:t"+firsetLine[0]);

            log.info("url是:\t"+firsetLine[1]);

            log.info("Httpversion是:\t"+firsetLine[2]);

            log.info("-----输出结束-------------");

//返回客户端
            StringBuilder sendStr = new StringBuilder();

            sendStr.append("Http/1.1 200 Ok\r\n");

            sendStr.append("Content-Type:text/html;charset="+localCharSet+"\r\n");

            sendStr.append("\r\n");

            sendStr.append("<html><head><title>显示报文</title></head><body>");

            sendStr.append("接受到请求的报文是：+<br>");

            for (String s : requestMessage) {

                sendStr.append(s+"<br/>");

            }
            sendStr.append("</body></html>");

            buffer=ByteBuffer.wrap(sendStr.toString().getBytes(localCharSet));

            socketChannel.write(buffer);

            socketChannel.close();
        }else {
            socketChannel.close();

        }

    }

}
