package Model;

import Exceptions.BrokerDaoException;
import Exceptions.BrokerException;
import Exceptions.PublisherException;
import Interface.Broker;
import Interface.Publisher;

import java.util.UUID;

public class PublisherImpl implements Publisher {
    Broker broker;
    UUID id;
    public PublisherImpl(Broker broker) {
        this.broker = broker;
        this.id = UUID.randomUUID();
    }


    @Override
    public void registerWithBroker() throws PublisherException {
        try {
            this.broker.registerPublisher(this);
        } catch (BrokerException e) {
            e.printStackTrace();
        } catch (BrokerDaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deregisterWithBroker() throws PublisherException {
        try {
            this.broker.deregisterPublisher(this);
        } catch (BrokerException e) {
            e.printStackTrace();
        } catch (BrokerDaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessageOnBroker(String msg, String type) throws PublisherException {
        try {
            System.out.printf("Sending msg from publisher %s\n", this.id);
            this.broker.notify(msg, type);
        } catch (BrokerException e) {
            e.printStackTrace();
        } catch (BrokerDaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UUID getId() {
        return this.id;
    }
}
