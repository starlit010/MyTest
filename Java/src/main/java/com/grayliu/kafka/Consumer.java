package com.grayliu.kafka;

import java.io.FileNotFoundException;
import java.util.*;
import java.time.Duration;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

public class Consumer {

    public void commitAuto() throws FileNotFoundException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.58.62.239:9092,10.58.217.132:9092");
        props.put("enable.auto.commit", "false");
//        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        props.put("max.poll.records", 10000);
        props.put("group.min.session.timeout.ms",1000);
        props.put("group.id","test789");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        ArrayList<TopicPartition> topicPartitions = new ArrayList<TopicPartition>();
        Map<String, List<PartitionInfo>> listTopics = consumer.listTopics();
        Set<Map.Entry<String, List<PartitionInfo>>> entries = listTopics.entrySet();
<<<<<<< HEAD

        for (Map.Entry<String, List<PartitionInfo>> entry : entries) {
            System.out.println("topic:" + entry.getKey());
            System.out.println("topic:" + entry.getValue());

=======
        for (Map.Entry<String, List<PartitionInfo>> entry: entries) {
//            System.out.println("topic:" + entry.getKey());
//            System.out.println("topic:" + entry.getValue());
>>>>>>> 6a15cda51e1578d0a6e84bb05fa0d74cc61286e9
        }

        consumer.subscribe(Arrays.asList("cluster-test"));

//        new ConsumerRebalanceListener() {
//            @Override
//            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
//
//            }
//
//            @Override
//            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
//                System.out.println("*- in ralance:onPartitionsAssigned  ");
//                for (TopicPartition partition : collection) {
//                    System.out.println("*- partition:"+partition.partition());
//
//                    //获取消费偏移量，实现原理是向协调者发送获取请求
//                    OffsetAndMetadata offset = consumer.committed(partition);
//                    //设置本地拉取分量，下次拉取消息以这个偏移量为准
//                    consumer.seek(partition, offset.offset());
//                }
//            }
//        }
//        TopicPartition topicPartition = new TopicPartition("cluster-test", 0);
//        consumer.assign(Arrays.asList(new TopicPartition("cluster-test", 0)));
//        consumer.seekToBeginning(Arrays.asList(new TopicPartition("cluster-test", 0)));
//        consumer.assign(Arrays.asList(new TopicPartition("cluster-test", 0)));
//        consumer.seekToBeginning(Arrays.asList(new TopicPartition("cluster-test", 0)));//不改变当前offset
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(30));

            for (ConsumerRecord<String, String> record : records){



                System.out.printf("partition = %s, offset = %d, key = %s, value = %s%n",record.partition(), record.offset(), record.key(), record.value());

            }
        }



    }

    /**
     * @throws FileNotFoundException
     */
    public void commitControl(List<String> topics) throws FileNotFoundException {
        Properties props = KafkaUtils.getProperties("cosumer");
        props.put("bootstrap.servers", "10.58.62.239:9092,10.58.217.132:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("enable.auto.commit", "false");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(topics);
        final int minBatchSize = 2;
        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                buffer.add(record);
            }
            if (buffer.size() >= minBatchSize) {
                insertIntoDb(buffer);
                consumer.commitSync();
                buffer.clear();
            }
        }
    }

    public void getOffSet(String topic) throws FileNotFoundException {
        Properties props = KafkaUtils.getProperties("cosumer");
        props.put("bootstrap.servers", "10.58.62.239:9092,10.58.217.132:9092");
        props.put("enable.auto.commit", "true");
        props.put("group.id", "test123");
        props.put("auto.offset.reset", "earliest");
        props.put("max.poll.records", 10000);
        props.put("group.min.session.timeout.ms",1000);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topic));
//        List<PartitionInfo> partition = consumer.partitionsFor("cluster-test");
////        partition.
        TopicPartition topicPartition0 = new TopicPartition("cluster-test",0);
        TopicPartition topicPartition1 = new TopicPartition("cluster-test",1);
        Map<TopicPartition, OffsetAndMetadata> map = new HashMap<TopicPartition, OffsetAndMetadata>();
        map.put(topicPartition0, new OffsetAndMetadata(0));
        map.put(topicPartition1, new OffsetAndMetadata(0));
        List<TopicPartition> list = new ArrayList<TopicPartition>();
        list.add(topicPartition0);
        list.add(topicPartition1);
//        consumer.poll(Duration.ofMillis(30));
//        consumer.commitSync(map);
//        consumer.close();

        Map<TopicPartition, Long> rtn = consumer.endOffsets(list);
        Iterator<Map.Entry<TopicPartition, Long>> iterator = rtn.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        consumer.close();

//        ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
//        for (TopicPartition partition : records.partitions()) {
//            List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
//            for (ConsumerRecord<String, String> record : partitionRecords) {
//                System.out.println(record.offset() + ": " + record.value());
//            }
//            long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
//            consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(0)));
//
//        }
    }

    public void setOffSet(String topic) throws FileNotFoundException {
        Properties props = KafkaUtils.getProperties("cosumer");
        props.put("bootstrap.servers", "10.58.62.239:9092,10.58.217.132:9092");
        props.put("enable.auto.commit", "true");
        props.put("group.id", "test123");
        props.put("auto.offset.reset", "earliest");
        props.put("max.poll.interval.ms", 300000);
        props.put("group.min.session.timeout.ms",1000);
        props.put("max.poll.records", 10000);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        TopicPartition topicPartition0 = new TopicPartition("cluster-test",0);
        TopicPartition topicPartition1 = new TopicPartition("cluster-test",1);
        consumer.subscribe(Arrays.asList(topic));
        List<PartitionInfo> partitionInfos = consumer.partitionsFor(topic);

        for(PartitionInfo partitionInfo : partitionInfos){
            System.out.println(partitionInfo.toString());
        }

        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
        for (TopicPartition partition : records.partitions()) {
            System.out.println(partition.toString());


//            List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
//
//            for (ConsumerRecord<String, String> record : partitionRecords) {
//                System.out.println(record.offset() + ": " + record.value());
//            }
//            long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
//            consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
        }


//        consumer.seek(topicPartition0, 210);
//        consumer.seek(topicPartition1, 210);
////        List<PartitionInfo> partition = consumer.partitionsFor("cluster-test");
//////        partition.
//
//        ConsumerRecords<String, String> records = consumer.poll(100);
//
//        for (ConsumerRecord<String, String> record : records) {
//            System.err.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            consumer.commitSync();
//        }
    }

    public void setSeek(String topic) throws FileNotFoundException {
        Properties props = KafkaUtils.getProperties("cosumer");
        props.put("bootstrap.servers", "10.58.62.239:9092,10.58.217.132:9092");
        props.put("enable.auto.commit", "false");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
<<<<<<< HEAD

//        consumer.subscribe(topics);
//        consumer.seek(new TopicPartition("cluster-test", 0), 1);

=======
>>>>>>> 6a15cda51e1578d0a6e84bb05fa0d74cc61286e9
//        consumer.subscribe(Arrays.asList(topic));
        TopicPartition topicPartition = new TopicPartition("cluster-test", 0);
        consumer.assign(Collections.singletonList(topicPartition));
        consumer.seekToBeginning(Collections.singleton(topicPartition));
<<<<<<< HEAD

=======
>>>>>>> 6a15cda51e1578d0a6e84bb05fa0d74cc61286e9
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
        for (ConsumerRecord<String, String> record : records) {
            System.err.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            consumer.commitSync();
        }
    }

    /**
     * doSomethings
     */
    private void insertIntoDb(List<ConsumerRecord<String, String>> buffer) {
        buffer.stream().map(x -> x.value()).forEach(System.err::println);
    }

    public void ManualOffset() {
        Properties props = new Properties();
        String topicName = "cluster-test";

        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", "30000");

<<<<<<< HEAD

=======
>>>>>>> 6a15cda51e1578d0a6e84bb05fa0d74cc61286e9
        KafkaConsumer<String ,String> consumer = new KafkaConsumer<String ,String>(props);
        consumer.subscribe(Arrays.asList(topicName));
        consumer.assign(Arrays.asList(new TopicPartition(topicName, 0)));
        consumer.seekToBeginning(Arrays.asList(new TopicPartition(topicName, 0)));//不改变当前offset

<<<<<<< HEAD

=======
>>>>>>> 6a15cda51e1578d0a6e84bb05fa0d74cc61286e9
        final int minBatchSize = 5;
        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("consumer message values is " + record.value() + " and the offset is " + record.offset());
                buffer.add(record);
            }
            if (buffer.size() >= minBatchSize) {
                System.out.println("now commit offset" + buffer.size());
                consumer.commitSync();
                buffer.clear();
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Consumer consumer = new Consumer();
//        consumer.setOffSet("cluster-test");
//        consumer.getOffSet("cluster-test");
        consumer.commitAuto();
//        consumer.setSeek("cluster-test");
    }
}