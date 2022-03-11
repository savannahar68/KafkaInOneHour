package Interface;

import Exceptions.BrokerDaoException;
import Exceptions.BrokerException;

import java.util.Collection;

public interface Broker {
    void subscribe(Subscriber subscriber, Collection<String> types) throws BrokerException, BrokerDaoException;
    void unsubscribe(Subscriber subscriber) throws BrokerException, BrokerDaoException;
    void notify(String event, String type) throws BrokerException, BrokerDaoException;
    void registerPublisher(Publisher publisher) throws BrokerException, BrokerDaoException;
    void deregisterPublisher(Publisher publisher) throws BrokerException, BrokerDaoException;
}
