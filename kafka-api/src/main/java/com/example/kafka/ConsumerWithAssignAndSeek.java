package com.example.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

@Slf4j
public class ConsumerWithAssignAndSeek {

  public static void main(String[] args) {
    // Create the Producer Properties/
    // https://kafka.apache.org/documentation/#consumerconfigs
    Properties properties = new Properties();
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    // Create the Consumer
    KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

    // Assign and seek are mostly used to replay data pr fetch a specific message

    // Assign
    TopicPartition topicPartition = new TopicPartition("first_topic", 1);
    kafkaConsumer.assign(Collections.singleton(topicPartition));

    // Seek
    kafkaConsumer.seek(topicPartition, 15L);

    // Poll data
    while (true) {
      ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(1));
      records.forEach(record -> log.info("Topic {} Key {} Value {} Partition {} Offset {}",
          record.key(), record.topic(), record.value(), record.partition(), record.offset()));
    }
  }

}