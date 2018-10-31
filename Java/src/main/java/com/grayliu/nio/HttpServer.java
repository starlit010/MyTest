package com.grayliu.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.*;

/**
 * Created by liuhui-ds9 on 2018/10/22.
 */
@Slf4j
public class HttpServer {


    public static void main(String...args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8080));
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            int select = selector.select();

            if(select == 0){
                log.info("请求超时...");
                continue;
            }

            log.info("开始处理请求...");

            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();

            while(keyIter.hasNext()){
                SelectionKey key = keyIter.next();
                new Thread(new HttpHandler(key)).run();
                keyIter.remove();
            }
        }
    }

}


