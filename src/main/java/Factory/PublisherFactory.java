package Factory;

import Interface.Broker;
import Interface.Factory;
import Interface.Publisher;
import Interface.Subscriber;
import Model.PublisherImpl;
import Model.SubscriberImpl;

public class PublisherFactory implements Factory {
    public Publisher get() throws Exception {
        // Config from come from properties
        Factory brokerFactory = AbstractFactory.getFactoryForKey("broker");
        Broker broker = brokerFactory.get();
        return new PublisherImpl(broker);
    }
}
