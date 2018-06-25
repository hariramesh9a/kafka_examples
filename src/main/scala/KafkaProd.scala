import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/**
  * Created by ARUMUHX on 6/21/2018.
  */
object KafkaProd {
  def main(args: Array[String]): Unit = {
    val topic = "haritest"
    val brokers = "nn01moscdev.xxx.com:9092"
    val props = new Properties()
    props.put("bootstrap.servers", brokers)
    //    props.put("client.id", "ScalaProducerExample")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    System.setProperty("java.security.krb5.conf", "/etc/krb5.conf")
    System.setProperty("java.security.auth.login.config", "/home/arumuhx/kafka/jaas.conf")
    System.setProperty("javax.security.auth.useSubjectCredsOnly", "true")

    props.put("metadata.broker.list", "nn01moscdev.xxx.com:9092")
    props.put("serializer.class", "kafka.serializer.StringEncoder")
    props.put("request.required.acks", "1")
    props.put("security.protocol", "SASL_PLAINTEXT")


    val producer = new KafkaProducer[String, String](props)
    for (i <- 1 to 50) {
      val record = new ProducerRecord(topic, "key", s"hello $i")
      producer.send(record)
    }
    producer.close()


  }
}
