package com.grayliu.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.ServerCnxn;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by liuhui-ds9 on 2017/9/6.
 */
public class ZKList implements Watcher {

    protected ZooKeeper zk ;
    private int SESSION_TIMEOUT = 3000;
    private CountDownLatch cdl = new CountDownLatch(1);
    private static final Charset CHARSET= Charset.forName("UTF-8");

    public void connection(String host) throws IOException, InterruptedException {
        zk = new ZooKeeper(host,SESSION_TIMEOUT,this);
        cdl.await();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            cdl.countDown();
        }
    }

    public void list(String path) throws KeeperException, InterruptedException {
        List<String> list = zk.getChildren(path,this);
        System.out.println(list.toString());
    }

    public void getData(String path) throws KeeperException, InterruptedException{
        byte[] data = zk.getData(path, this, null);
        System.out.println(new String(data,CHARSET));
    }


}
