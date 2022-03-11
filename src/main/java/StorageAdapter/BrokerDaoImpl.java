package StorageAdapter;

import Interface.BrokerDao;
import Interface.Publisher;
import Interface.Subscriber;
import Exceptions.BrokerDaoException;
import Model.BrokerImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BrokerDaoImpl implements BrokerDao {
    Map<Subscriber, Collection<String>> subscriberCollectionHashMap;
    Collection<Publisher> publisherCollection;
    private static volatile BrokerDaoImpl INSTANCE;

    private BrokerDaoImpl() {
        this.subscriberCollectionHashMap = new HashMap<>();
        this.publisherCollection = new ArrayList<>();
    }

    public static synchronized BrokerDao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BrokerDaoImpl();
        }
        return INSTANCE;
    }

    @Override
    public Subscriber addSubscriber(Subscriber subscriber, Collection<String> messageType) throws BrokerDaoException {
        if (subscriberCollectionHashMap.containsKey(subscriber)) throw new BrokerDaoException("Subscriber already exist");
        subscriberCollectionHashMap.put(subscriber, messageType);
        return subscriber;
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) throws BrokerDaoException {
        subscriberCollectionHashMap.remove(subscriber);
    }

    @Override
    public Collection<Subscriber> getSubscribersWithType(String messageType) throws BrokerDaoException {
        Collection<Subscriber> subscribers = new ArrayList<>();
        subscriberCollectionHashMap.forEach((subscriber, strings) -> {
            if (strings.stream().filter(s -> s.equals(messageType)).count() > 0) subscribers.add(subscriber);
        });
        return subscribers;
    }

    @Override
    public Publisher addPublisher(Publisher publisher) throws BrokerDaoException {
        if (publisherCollection.contains(publisher)) throw new BrokerDaoException("Publisher already exist");
        publisherCollection.add(publisher);
        return publisher;
    }

    @Override
    public void removePublisher(Publisher publisher) throws BrokerDaoException {
        publisherCollection.remove(publisher);
    }
}
