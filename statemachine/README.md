![image](./images/confluent-logo-300-2.png)

# Overview

Send some JSON data to `my_in_topic` using `kafkacat`

```
echo '001|{id:"001", data:"hi there"}'| docker-compose exec -T kafkacat kafkacat -b kafka:29092 -P -t my_in_topic -K "|"
```
And read it back

```
 docker-compose exec kafkacat kafkacat -b kafka:29092 -C -t my_in_topic -o beginning
```

Run the application as follows

```
mvn spring-boot:run -Dspring-boot.run.arguments=--logging.level.io.confluent.test=TRACE
```