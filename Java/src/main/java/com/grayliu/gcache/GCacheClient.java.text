package com.grayliu.gcache;

import redis.GcacheClient;

/**
 * Created by liuhui-ds9 on 2017/9/5.
 */
public class GCacheClient {

    public static void main(String...args){

        //bussiness路径 path /gcache/businesses/TEST
//        GcacheClient client = new GcacheClient("10.112.179.149:2181,10.112.179.150:2181,10.112.179.151:2181","TEST");
        //集群信息 cluster:common_cluster|namespace:d|loadbalance:ramdom|master:r1|slave:r1|clusterstate:simple|permits:100
        GcacheClient client = new GcacheClient("10.58.22.191:2181,10.58.22.192:2181,10.58.22.193:2181,10.58.50.149:2181,10.58.50.150:2181,10.58.53.217:2181,10.58.53.218:2181,10.58.188.147:2181,10.58.188.146:2181,10.58.188.148:2181","IM_KF_DATA_CACHE") ;
//        GcacheClient client = new GcacheClient("10.112.179.149:2181,10.112.179.150:2181,10.112.179.151:2181","IM_KF_DATA_CACHE") ;
//        client.expire("test_lua_cache",60*2);
//        client.set("test_lua_cache","123");
//        String out = client.get("F:26630927566_homeSite_currentCartID");
//        d:test_lua_cache  d是namespace，这个值是保存在zk上的
//        String out = client.get("d:test_lua_cache");
//        String out = client.get("P:100011895567_homeSite_totalQuantity");
//        String out = client.get("100011895567_homeSite_totalQuantity");
          String out = client.hget("channelId:144506:token","2");
//          String out = client.hget("1:skillGroup:6",123500+"");
//        String out = client.get("100011895567_mobileSite_totalQuantity");
//        String out = client.get("100011907278_homeSite_logined_totalQuantity");
        System.out.println(out);
        client.close();
    }

}
