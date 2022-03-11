import Factory.AbstractFactory;
import Interface.Factory;
import Interface.Publisher;
import Interface.Subscriber;

import java.util.Arrays;
import java.util.List;

import Factory.PublisherFactory;
import Factory.SubscriberFactory;

public class KafkaMain {
    public static void main(String[] args) {
        try {
            Factory publisherFactory = AbstractFactory.getFactoryForKey("publisher");
            Factory subscriberFactory = AbstractFactory.getFactoryForKey("subscriber");

            Publisher p1 = publisherFactory.get();
            Publisher p2 = publisherFactory.get();

            Subscriber s1 = subscriberFactory.get();
            Subscriber s2 = subscriberFactory.get();
            Subscriber s3 = subscriberFactory.get();

            p1.registerWithBroker();
            p2.registerWithBroker();

            s1.registerWithBroker(List.of("JAVA"));
            s2.registerWithBroker(Arrays.asList("JAVA", "PYTHON"));
            s3.registerWithBroker(Arrays.asList("PYTHON", "JAVASCRIPT", "GOLANG"));

            p1.sendMessageOnBroker("JAVA is OOP based langauge", "JAVA");
            p1.sendMessageOnBroker("GOLANG is not OOP based langauge", "GOLANG");
            p1.sendMessageOnBroker("PYTHON is OOP based langauge", "PYTHON");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
