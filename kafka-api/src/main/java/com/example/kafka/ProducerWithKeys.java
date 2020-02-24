package com.example.kafka;

import java.util.Objects;
import java.util.Properties;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

@Slf4j
public class ProducerWithKeys {

  public static void main(String[] args) {
    // Create the Producer Properties/
    // https://kafka.apache.org/documentation/#producerconfigs
    Properties properties = new Properties();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    // Create the Producer
    KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

    // Create the ProducerRecord
    String topic = "first_topic";
    String key = "some-key";
    String value = UUID.randomUUID().toString();
    ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);

    // Send data - asynchronous
    producer.send(producerRecord, (metadata, exception) -> {
      if (Objects.isNull(exception)) {
        log.info("Producer OK, topic {}, partition {}, offset {}, timestamp {}", metadata.topic(),
            metadata.partition(), metadata.offset(), metadata.timestamp());
      } else {
        log.error("Producer NOK", exception);
      }
    });

    producer.flush();
    producer.close();
  }

}