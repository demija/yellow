
# Yellow backend
The Offer domain determines the events, along with their associated markets and outcomes, that end users will view when they access a client application, such as a web or mobile application. It encompasses a collection of entities with interconnected relationships and a hierarchical structure.


## Getting Started
To get this project up and running on your local machine, follow these steps:


### Prerequisites
Ensure you have the following installed on your system:
- Java: [Download and Install Java](https://www.oracle.com/java/technologies/downloads/)
- PostgreSQL: [Download and Install PostgreSQL](https://www.postgresql.org/)
- Redis: [Download and Install Redis](https://redis.io/)
- Apache Kafka: [Download and Install Apache Kafka](https://kafka.apache.org/)


### Installation
Steps to install the project:

1. Clone this repository
2. On PostgreSQL create database: `yellow`


### Usage
Steps to run the project:

1. Start the Redis service on your localhost
2. Start the Kafka service on your localhost
3. Start the project from IDE ([Download and Install IntelliJ](https://www.jetbrains.com/idea/download/))


## Overview
When the project is up and running first you can visit http://localhost:8080/swagger-ui/index.html#/ to check OpenAPI definitions.

Initial state is loaded when the project is started, there is already some data.

Since Apache Kafka is used as stream implementation one can send Kafka messages (JSON format) over the command line (kafka-console-producer) on two topics `event` and `market`.
```bash
./kafka-console-producer.sh --broker-list localhost:9092 --topic markets
```
Market message
```json
{"id":"total","name":"Total","status":1,"outcomes":[{"id":"total-0.5","name":"1","status":1},{"id":"total- 1.5","name":"2","status":1}]}
```
___
```bash
./kafka-console-producer.sh --broker-list localhost:9092 --topic events
```
Event message
```json
{"id":"3","name":"Dev - NonDev","startsAt":"2030-06-02T20:00:00","status":1,"markets":[{"id":"3-1","marketId":"3way","status":1,"outcomes":[{"id":"3-1-1","outcomeId":"3way-1","status":1,"odds":1.1},{"id":"3-1-2","outcomeId ":"3way-2","status":1,"odds":20.1},{"id":"3-1-3","outcomeId":"3way-x","status":1,"odds":5.1}]}]}
```