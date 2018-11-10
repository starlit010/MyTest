package main.java.com.grayliu.kafka;

import java.io.FileNotFoundException;
import java.util.*;
import java.time.Duration;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

public class Consumer {

    public void commitAuto() throws FileNotFoundException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.58.62.239:9092,10.58.217.132:9092");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        ArrayList<TopicPartition> topicPartitions = new ArrayList<TopicPartition>();
        Map<String, List<PartitionInfo>> listTopics = consumer.listTopics();
        Set<Map.Entry<String, List<PartitionInfo>>> entries = listTopics.entrySet();
        for (Map.Entry<String, List<PartitionInfo>> entry : entries) {
            System.out.println("topic:" + entry.getKey());
            System.out.println("topic:" + entry.getValue());
        }

        consumer.subscribe(Arrays.asList("cluster-test"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(30));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }

    /**
     * @throws FileNotFoundException
     */
    public void commitControl(List<String> topics) throws FileNotFoundException {
        Properties props = KafkaUtils.getProperties("cosumer");
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

    public void setOffSet(List<String> topics) throws FileNotFoundException {
        Properties props = KafkaUtils.getProperties("cosumer");
        props.put("enable.auto.commit", "false");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(topics);

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
            for (TopicPartition partition : records.partitions()) {
                List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);

                for (ConsumerRecord<String, String> record : partitionRecords) {
                    System.out.println(record.offset() + ": " + record.value());
                }
                long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
                consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
            }
        }
    }

    public void setSeek(List<String> topics) throws FileNotFoundException {
        Properties props = KafkaUtils.getProperties("cosumer");
        props.put("enable.auto.commit", "false");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(topics);
        consumer.seek(new TopicPartition("cluster-test", 0), 1);
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

        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", "30000");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("cluster-test"));
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
        consumer.commitAuto();
    }
}