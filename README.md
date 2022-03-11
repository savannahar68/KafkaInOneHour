# KafkaInOneHour
Implementation of Observer Java OOD pattern

Tried to implement Publish Subscribe in one hour to mimic Kafka like behaviour using Observer OOD pattern.

High level description - 

* Build a Message Broker (Only one broker)
* Publishers should be able to publish msg to broker 
* Subscribers should be able to subscribe to broker on specific types of messages 
* Subscribers should receive only messages of subscribed types 
* The broker must store all messages it received 
* The broker must log all messages that are written or read from it. 
* Message type is dynamic 
* Broker should send message in async fashion

### OOD Patterns used

1. Observer
2. Adapter
3. Factory
4. Abstract Factory
5. Strategy
6. Proxy
7. Singleton

#### How to run this project

Clone the project and run the KafkaMain.java class.
