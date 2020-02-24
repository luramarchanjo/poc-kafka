package com.example.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

@Slf4j
public class Consumer {

  public static void main(String[] args) {
    // Create the Producer Properties/
    // https://kafka.apache.org/documentation/#consumerconfigs
    Properties properties = new Properties();
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    properties.put(ConsumerConfig.GROUP_ID_CONFIG, "first-application");
    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    // Create the Consumer
    KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

    // Subscribe the Consumer
    kafkaConsumer.subscribe(Collections.singleton("first_topic"));

    // Poll data
    while (true) {
      ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(1));
      records.forEach(record -> log.info("Key {} Value {} Partition {} Offset {}", record.key(),
          record.value(), record.partition(), record.offset()));
    }
  }

}