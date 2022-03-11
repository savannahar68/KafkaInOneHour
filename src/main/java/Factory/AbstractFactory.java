package Factory;

import Interface.Factory;

public class AbstractFactory {
    public static Factory getFactoryForKey(String key) throws Exception {
        if (key.equals("publisher")) return new PublisherFactory();
        if (key.equals("subscriber")) return new SubscriberFactory();
        if (key.equals("broker")) return new BrokerFactory();
        throw new Exception("Key passed is incorrect");
    }
}
