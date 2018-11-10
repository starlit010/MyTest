package main.java.com.grayliu.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class SimpleProducer {

    public static void main(String[] args) throws FileNotFoundException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.58.217.132:9092,10.58.62.239:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread_1 = new Thread() {
            @Override
            public void run() {
//                countDownLatch.countDown();
                for (int i = 0; i < 100; i++) {
                    ProducerRecord<String, String> record = new ProducerRecord<String, String>("cluster-test", "1232323=======>" + i);
                    producer.send(record, new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception e) {
                            if (e != null) {
                                System.out.println("the producer has a error:" + e.getMessage());
                            } else {
                                System.out.println("The offset of the record we just sent is: " + metadata.offset());
                                System.out.println("The partition of the record we just sent is: " + metadata.partition());
                            }
                        }
                    });
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e1) {
//                        e1.printStackTrace();
//                    }
                }
            }
        };

        Thread thread_2 = new Thread() {
            @Override
            public void run() {
//                countDownLatch.countDown();
                for (int i = 0; i < 5; i++) {
                    ProducerRecord<String, String> record = new ProducerRecord<String, String>("cluster-test", "22333222323saada=======>" + i);
                    producer.send(record, new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception e) {
                            if (e != null) {
                                System.out.println("the producer has a error:" + e.getMessage());
                            } else {
                                System.out.println("The offset of the record we just sent is: " + metadata.offset());
                                System.out.println("The partition of the record we just sent is: " + metadata.partition());
                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        };

        try {
            thread_1.start();
//            Thread.sleep(5000);
//            thread_2.start();
            thread_1.join();
//            thread_2.join();
            producer.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}