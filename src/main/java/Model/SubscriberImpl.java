package Model;

import Exceptions.BrokerDaoException;
import Exceptions.BrokerException;
import Exceptions.SubscriberException;
import Interface.Broker;
import Interface.Subscriber;

import java.util.Collection;
import java.util.UUID;

public class SubscriberImpl implements Subscriber {
    Broker broker;
    UUID id;
    public SubscriberImpl(Broker broker) {
        this.broker = broker;
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }

    @Override
    public void registerWithBroker(Collection<String> msgTypes) throws SubscriberException {
        try {
            this.broker.subscribe(this, msgTypes);
        } catch (BrokerException e) {
            e.printStackTrace();
        } catch (BrokerDaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deregisterWithBroker() throws SubscriberException {
        try {
            this.broker.unsubscribe(this);
        } catch (BrokerException e) {
            e.printStackTrace();
        } catch (BrokerDaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void on(String event) throws SubscriberException {
        System.out.printf("Received event for subscriber %s for event %s\n",this.id, event);
    }
}
