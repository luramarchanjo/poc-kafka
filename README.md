# Overview

This is a repository to keep my studies about Apache Kafka

## Topics

#### Create a topic

```
sh kafka-topics.sh --bootstrap-server localhost:9092 --topic <NAME> --create --partitions 3 --replication-factor 1
```

#### Delete a topic

```
sh kafka-topics.sh --bootstrap-server localhost:9092 --topic <NAME> --delete
```

#### List topics

```
sh kafka-topics.sh --zookeeper localhost:2181 --list
```

#### Describe topic

```
sh kafka-topics.sh --zookeeper localhost:2181 --topic <NAME> --describe
```

## Producers

```
sh kafka-console-producer.sh --topic <NAME> --broker-list localhost:9092
```