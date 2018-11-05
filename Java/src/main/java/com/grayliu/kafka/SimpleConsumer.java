package com.grayliu.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.*;

public class SimpleConsumer {

    public static void main(String[] args) throws FileNotFoundException {



        Thread thread_1 = new Thread(){
            @Override
            public void run(){
                Properties props = new Properties();
                props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.58.62.239:9092,10.58.217.132:9092");
                props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
                props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
                props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
                props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
                props.put(ConsumerConfig.GROUP_ID_CONFIG, "partition_1");
                KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

                Map<String, List<PartitionInfo>> listTopics = consumer.listTopics();
                Set<Map.Entry<String, List<PartitionInfo>>> entries = listTopics.entrySet();
                for (Map.Entry<String, List<PartitionInfo>> entry: entries) {
                    System.out.println("topic:" + entry.getKey());
                    System.out.println("topic:" + entry.getValue());
                }

                consumer.subscribe(Arrays.asList("cluster-test"));
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(30));
                    for (ConsumerRecord<String, String> record : records){
                        System.out.printf("offset = %d, key = %s, value = %s, partition = %s, coustom = %s%n", record.offset(), record.key(), record.value(), record.partition(), 1);
                    }
                }
            }
        };

        Thread thread_2 = new Thread(){
            @Override
            public void run(){
                Properties props = new Properties();
                props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.58.62.239:9092,10.58.217.132:9092");
                props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
                props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
                props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
                props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
                props.put(ConsumerConfig.GROUP_ID_CONFIG, "partition_1");
                KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

                Map<String, List<PartitionInfo>> listTopics = consumer.listTopics();
                Set<Map.Entry<String, List<PartitionInfo>>> entries = listTopics.entrySet();
                for (Map.Entry<String, List<PartitionInfo>> entry: entries) {
                    System.out.println("topic:" + entry.getKey());
                    System.out.println("topic:" + entry.getValue());
                }

                consumer.subscribe(Arrays.asList("cluster-test"));
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(30));
                    for (ConsumerRecord<String, String> record : records){
                        System.out.printf("offset = %d, key = %s, value = %s, partition = %s, coustom = %s%n", record.offset(), record.key(), record.value(), record.partition(), 2);
                    }
                }
            }
        };

        Thread thread_3 = new Thread(){
            @Override
            public void run(){
                Properties props = new Properties();
                props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.58.62.239:9092,10.58.217.132:9092");
                props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
                props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
                props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
                props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
                props.put(ConsumerConfig.GROUP_ID_CONFIG, "partition_1");
                KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

                Map<String, List<PartitionInfo>> listTopics = consumer.listTopics();
                Set<Map.Entry<String, List<PartitionInfo>>> entries = listTopics.entrySet();
                for (Map.Entry<String, List<PartitionInfo>> entry: entries) {
                    System.out.println("topic:" + entry.getKey());
                    System.out.println("topic:" + entry.getValue());
                }

                consumer.subscribe(Arrays.asList("cluster-test"));
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(30));
                    for (ConsumerRecord<String, String> record : records){
                        System.out.printf("offset = %d, key = %s, value = %s, partition = %s, coustom = %s%n", record.offset(), record.key(), record.value(), record.partition(), 3);
                    }
                }
            }
        };


        try {
            thread_1.start();
            thread_2.start();
            thread_1.join();
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}