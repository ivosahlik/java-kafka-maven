# Kafka - Data Contracts using Schema Registry

This repository has the content to interact with Kafka using AVRO and Schema Registry.

## Set up Kafka Environment using Docker

- This should set up the Zookeeper and Kafka Broker in your local environment

```aidl
docker-compose up
```

### Verify the Local Kafka Environment

- Run this below command

```
docker ps
```

- You should be below containers up and running in local

```
CONTAINER ID   IMAGE                                   COMMAND                  CREATED          STATUS          PORTS                                            NAMES
0205c629dc75   confluentinc/cp-schema-registry:7.1.0   "/etc/confluent/dock…"   39 minutes ago   Up 39 minutes   0.0.0.0:8081->8081/tcp                           schema-registry
abd0ad9dff78   confluentinc/cp-server:7.1.0            "/etc/confluent/dock…"   39 minutes ago   Up 39 minutes   0.0.0.0:9092->9092/tcp, 0.0.0.0:9101->9101/tcp   broker
05e3bb460034   confluentinc/cp-zookeeper:7.1.0         "/etc/confluent/dock…"   39 minutes ago   Up 39 minutes   2888/tcp, 0.0.0.0:2181->2181/tcp, 3888/tcp       zookeeper
```

### Interacting with Kafka

#### Produce Messages

- This command should take care of logging in to the Kafka container.

```
docker exec -it broker bash
```

- Command to produce messages in to the Kafka topic.

```
kafka-console-producer --broker-list localhost:9092 --topic test-topic
```





#### Consume Messages

- This  command should take care of logging in to the Kafka container.

```
docker exec -it broker bash
```
- Command to produce messages in to the Kafka topic.

```
kafka-console-consumer --bootstrap-server localhost:9092 --topic test-topic
```






### Interacting with Kafka using AVRO Records

#### Produce AVRO Messages

- This command should take care of logging in to the Schema Registry container.

```
docker exec -it schema-registry bash
```

- Run the **kafka-avro-console-producer** with the Schema

```
kafka-avro-console-producer --broker-list broker:29092 --topic greetings --property value.schema='{"type": "record","name":"Greeting","fields": [{"name": "greeting","type": "string"}]}'
```

- Publish the **Greeting** message

```
{"greeting": "Good Morning!, AVRO"}
```

```
{"greeting": "Good Evening!, AVRO"}
```

```
{"greeting": "Good Night!, AVRO"}
{"greetinga": "Good Night!, AVRO"}
```




### Consume AVRO Messages

- This  command should take care of logging in to the Schema Registry container.

```
docker exec -it schema-registry bash

```

- Run the kafka-avro-console-consumer

```
kafka-avro-console-consumer --bootstrap-server broker:29092 --topic greetings --from-beginning
```

