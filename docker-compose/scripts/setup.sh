#!/bin/sh

confluent-hub install --component-dir ./connect-plugins/ --no-prompt jcustenborder/kafka-connect-spooldir:2.0.43
confluent-hub install --component-dir ./connect-plugins/ --no-prompt wepay/kafka-connect-bigquery:1.3.0
confluent-hub install --component-dir ./connect-plugins/ --no-prompt debezium/debezium-connector-postgresql:1.0.0
confluent-hub install --component-dir ./connect-plugins/ --no-prompt hpgrahsl/kafka-connect-mongodb:1.3.1
