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

## Consumers

#### Reading only new messages

```
sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <NAME>

```

#### Reading all messagens

```
sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <NAME> --from-beginning
```

## Consumer Group

```
sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <NAME> --group <GROUP_NAME>
```

#### List Consumer Group

```
sh kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
```

#### Describe Consumer Group

```
sh kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe -group <GROUP_NAME>
```

#### Resetting Offset

```
sh kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group <GROUP_NAME> --reset-offsets --to-earliest --execute --all-topics
```

## Frameworks

[Kafka Java API](https://kafka.apache.org/documentation/#api)

[Spring Kafka](https://docs.spring.io/spring-kafka/reference/html/#preface)

## Tools

#### UI

[Conduktor](https://www.conduktor.io/)

#### CLI

[Kafkacat](https://github.com/edenhill/kafkacat)

#### Kafka, Zookeeper, Schema Registry, Kafka-Connect for development

To start [Kafka, Zookeeper, Schema Registry, Kafka-Connect](https://github.com/lensesio/fast-data-dev) run the command below:

`docker-compouse up`

After one minute, open the link http://127.0.0.1:3030