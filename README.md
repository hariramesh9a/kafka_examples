# Kafka client samples with kerberos


Code examples of how to produce to and consume from kafka topics on cluster which is kerberized

jaas.conf example

```sh
KafkaClient {
com.sun.security.auth.module.Krb5LoginModule required
useTicketCache=true
doNotPrompt=true
debug=true
principal="kafka/<principal name>"
useKeyTab=true
serviceName="kafka"
keyTab="<your_keytab>"
client=true;
};


```
With this jaas.conf added to the code in the src/ you should be able to connect to kafka topics.

##### A few command line cmd to make sure your kafka is properly set up


```sh
-- List kafka topics
kafka-topics --zookeeper zk_quorum with out /kafka at the end --list
--create a topic
kafka-topics --create --zookeeper zk_quorum with out /kafka at the end --replication-factor 1   --partitions 1 --topic haritest
--create a topic
kafka-console-producer --broker-list xxx.xxx.com:9092 --topic haritest --producer.config client.properties
--Run a Kafka console consumer:
export KAFKA_OPTS="-Djava.security.auth.login.config=jaas.conf"
kafka-console-consumer --new-consumer --topic haritest --from-beginning --bootstrap-server xxx.xxx.com:9092  --consumer.config client.properties
```
client.properties sample

```sh
security.protocol=SASL_PLAINTEXT
sasl.kerberos.service.name=kafka
```


