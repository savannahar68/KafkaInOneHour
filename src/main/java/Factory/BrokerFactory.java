package Factory;

import Interface.Broker;
import Interface.BrokerDao;
import Interface.Factory;
import Model.BrokerImpl;
import Proxies.BrokerLoggingProxy;
import StorageAdapter.BrokerDaoImpl;

public class BrokerFactory implements Factory {
    public Broker get() {
        // config comes from here
        BrokerDao brokerDao = BrokerDaoImpl.getInstance();
        // Broker config comes from properties
        Broker broker = BrokerImpl.getInstance(brokerDao);
        // here log based on config - considering it true for now
        broker = new BrokerLoggingProxy(broker);
        return broker;
    }
}
