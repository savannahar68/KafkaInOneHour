package Interface;

import Exceptions.SubscriberException;

import java.util.Collection;
import java.util.UUID;

public interface Subscriber {
    void registerWithBroker(Collection<String> msgTypes) throws SubscriberException;
    void deregisterWithBroker() throws SubscriberException;
    void on(String event) throws SubscriberException;
    UUID getId();
}
