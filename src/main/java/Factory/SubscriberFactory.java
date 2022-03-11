package Factory;

import Interface.Broker;
import Interface.Factory;
import Interface.Subscriber;
import Model.SubscriberImpl;

public class SubscriberFactory implements Factory {
    public Subscriber get() throws Exception {
        // Config from come from properties
        Factory brokerFactory = AbstractFactory.getFactoryForKey("broker");
        Broker broker = brokerFactory.get();
        return new SubscriberImpl(broker);
    }
}
