package com.grayliu.kafka;

/**
 * Created by liuhui-ds9 on 2018/8/8.
 */

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Properties;

public class KafkaUtils {
    @Test
    public void test() throws FileNotFoundException {
//        fastJSON();
    }


    public static Properties getProperties(String sourceName) throws FileNotFoundException {
        Properties properties = new Properties();
        //����brokerServer(kafka)ip��ַ
        //        props.put("group.id","mygroup11");
//        props.put("enable.auto.commit", "false");
        //����ʹ���ʼ��offsetƫ����Ϊ��group.id�����硣��������ã������latest����topic����һ����Ϣ��offset
        //�������latest��������ֻ�ܵõ�����������������������Ϣ
//        properties.put("bootstrap.servers", "10.58.217.132:9092,10.58.62.239:9092");
        properties.put("bootstrap.servers","10.115.0.149:9092");

//        properties.put("group.id", "group");
//        properties.put("bootstrap.servers", "10.58.217.132:9092,10.58.62.239:9092");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

//    public static void fastJSON() throws FileNotFoundException {
//        Object o = JSON.toJSON(new FileReader("src/main/resources/kafka"));
//        System.out.println(o);
//    }

}
