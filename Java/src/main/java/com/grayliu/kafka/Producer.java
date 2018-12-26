package com.grayliu.kafka;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {

    public static void main(String[] args) throws FileNotFoundException {
//        Properties props = new Properties();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.58.217.132:9092,10.58.62.239:9092");
//        props.put(ProducerConfig.ACKS_CONFIG, "all");
//        props.put(ProducerConfig.RETRIES_CONFIG, 3);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
//        for (int i = 0; i < 10; i++) {
//
////            ProducerRecord<String, String> record = new ProducerRecord<String, String>("cluster-test", "今天天气不错=======>" + i);
////            producer.send(record, new Callback() {
////                @Override
////                public void onCompletion(RecordMetadata metadata, Exception e) {
////                    if (e != null) {
////                        System.out.println("the producer has a error:" + e.getMessage());
////                    } else {
////                        System.out.println("The offset of the record we just sent is: " + metadata.offset());
////                        System.out.println("The partition of the record we just sent is: " + metadata.partition());
////                    }
////                }
////            });
//
//            ProducerRecord<String, String> record = new ProducerRecord<String, String>("cluster-test","今天天气不错=======>" + i);
//            producer.send(record);
////            producer.send(record, new Callback() {
////                @Override
////                public void onCompletion(RecordMetadata metadata, Exception e) {
////                    if (e != null) {
////                        System.out.println("the producer has a error:" + e.getMessage());
////                    } else {
////                        System.out.println("The offset of the record we just sent is: " + metadata.offset());
////                        System.out.println("The partition of the record we just sent is: " + metadata.partition());
////                    }
////                }
////            });
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
//        }
//        producer.close();

        System.out.println(4.028*100);
    }
}