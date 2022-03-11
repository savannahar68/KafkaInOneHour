package Interface;

import java.util.Collection;
import Exceptions.BrokerDaoException;

public interface BrokerDao {
    Subscriber addSubscriber(Subscriber subscriber, Collection<String> messageType) throws BrokerDaoException;
    void removeSubscriber(Subscriber subscriber) throws BrokerDaoException;
    Collection<Subscriber> getSubscribersWithType(String messageType) throws BrokerDaoException;
    Publisher addPublisher(Publisher publisher) throws BrokerDaoException;
    void removePublisher(Publisher publisher) throws BrokerDaoException;
}
