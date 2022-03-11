package Model;

import Exceptions.BrokerDaoException;
import Exceptions.BrokerException;
import Exceptions.SubscriberException;
import Interface.Broker;
import Interface.BrokerDao;
import Interface.Publisher;
import Interface.Subscriber;

import java.util.Collection;

public class BrokerImpl implements Broker {
    BrokerDao dao;
    private static volatile BrokerImpl INSTANCE;

    private BrokerImpl(BrokerDao dao) {
        this.dao = dao;
    }

    public static synchronized Broker getInstance(BrokerDao dao) {
        if (INSTANCE == null) INSTANCE = new BrokerImpl(dao);
        return INSTANCE;
    }

    @Override
    public void subscribe(Subscriber subscriber, Collection<String> types) throws BrokerException, BrokerDaoException {
        dao.addSubscriber(subscriber, types);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) throws BrokerException, BrokerDaoException {
        dao.removeSubscriber(subscriber);
    }

    @Override
    public void notify(String event, String type) throws BrokerException, BrokerDaoException {
        Collection<Subscriber> subscribersList = dao.getSubscribersWithType(type);
        subscribersList.parallelStream().forEach(subscriber -> {
            try {
                subscriber.on(event);
            } catch (SubscriberException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void registerPublisher(Publisher publisher) throws BrokerException, BrokerDaoException {
        dao.addPublisher(publisher);
    }

    @Override
    public void deregisterPublisher(Publisher publisher) throws BrokerException, BrokerDaoException {
        dao.removePublisher(publisher);
    }
}
