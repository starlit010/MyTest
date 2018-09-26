package com.grayliu.zk;

import org.I0Itec.zkclient.ZkConnection;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.List;

/**
 * Created by liuhui-ds9 on 2017/9/6.
 */
public class ZkClient {



//    执行流程是，首先根据bussiness获得从zk上获取集群信息，在zk指定路径下的childdata数据中，包括集群在zk上的名字，集群的权限，负载均衡方式
//    然后根据集群的名字在zk上找到集群列表
//    注意ZK的地址有一部分的是固定地址保存在配置文件中不需要填写，只要指明可变地址就可以了
//    另外ZK的数据结构是地址和数据

    public static void main(String...args) throws IOException, InterruptedException, KeeperException {
        ZKList cw = new ZKList();
        cw.connection("10.58.22.191:2181,10.58.22.192:2181,10.58.22.193:2181,10.58.50.149:2181,10.58.50.150:2181,10.58.53.217:2181,10.58.53.218:2181,10.58.188.147:2181,10.58.188.146:2181,10.58.188.148:2181");
//        cw.connection("10.112.179.149:2181,10.112.179.150:2181,10.112.179.151:2181");
//        cw.list("/gcache/businesses");

        //gcache-prxoy��Ⱥ
    //        cw.list("/gcache/proxy/area_page_cluster");
        //redis��Ⱥ
        //集群信息，前面的地址是固定的
//        cw.getData("/gcache/businesses/TEST");
//        cw.getData("/gcache/businesses/IM_KF_DATA_CACHE");
//        cw.list("/gcache/businesses");
        cw.getData("/gcache/businesses/PG_TRADING_TOTAL_BT");
//        cw.getData("/gcache/businesses/PG_TRADING_TOTAL_BT");
        //服务器信息
//        cw.list("/gcache/clusters/common_cluster");

//        cw.list("/gcache/clusters/common_cluster_new");

//        cw.list("/locks/appraiseSchedulerGroup/appraiseSchedulerLock");

    }


}
