package Proxies;

import Exceptions.BrokerDaoException;
import Exceptions.BrokerException;
import Interface.Broker;
import Interface.Publisher;
import Interface.Subscriber;
import java.util.Collection;

public class BrokerLoggingProxy implements Broker {

    Broker broker;
    public BrokerLoggingProxy(Broker broker) {this.broker = broker;}

    @Override
    public void subscribe(Subscriber subscriber, Collection<String> types) throws BrokerException, BrokerDaoException {
        System.out.println("Subscribing to subscriber with ID : " + subscriber.getId());
        this.broker.subscribe(subscriber, types);
        System.out.printf("Subscriber %s is successfully subscribed!\n", subscriber.getId());
    }

    @Override
    public void unsubscribe(Subscriber subscriber) throws BrokerException, BrokerDaoException {
        System.out.println("Unsubscribing subscriber with ID : " + subscriber.getId());
        this.broker.unsubscribe(subscriber);
        System.out.printf("Subscriber %s is successfully unsubscribed!\n", subscriber.getId());
    }

    @Override
    public void notify(String event, String type) throws BrokerException, BrokerDaoException {
        System.out.println("Notifying event : " + event);
        this.broker.notify(event, type);
        System.out.printf("Event notified!\n");
    }

    @Override
    public void registerPublisher(Publisher publisher) throws BrokerException, BrokerDaoException {
        System.out.println("Register to publisher with ID : " + publisher.getId());
        this.broker.registerPublisher(publisher);
        System.out.printf("Publisher %s is successfully registered!\n", publisher.getId());
    }

    @Override
    public void deregisterPublisher(Publisher publisher) throws BrokerException, BrokerDaoException {
        System.out.println("Deregistering to publisher with ID : " + publisher.getId());
        this.broker.deregisterPublisher(publisher);
        System.out.printf("Publisher %s is successfully deregistered!\n", publisher.getId());
    }
}
