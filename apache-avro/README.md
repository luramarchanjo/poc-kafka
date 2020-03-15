# Overview

## Schema

All the schemas are found in `/apache-avro-producer/src/main/avro`

## Set up

First start the kafka and kafka schame registry, to do that run the command below:

`docker-compose up`

After that you need to registry the schema `employee.v1.avsc` with the name `apache-avro-topic-value`

The, start the `apache-avro-producer` and the `apache-avro-consumer`

# References

[Guide to Spring Cloud Stream with Kafka, Apache Avro and Confluent Schema Registry](https://www.baeldung.com/spring-cloud-stream-kafka-avro-confluent)