lazy val root = (project in file(".")).
  settings(
    name := "kafka-prod",
    version := "1.0",
    scalaVersion := "2.10.6",
    mainClass in Compile := Some("KafkaProd")
  )


libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "1.1.0",
  "log4j" % "log4j" % "1.2.17"

)