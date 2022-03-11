package Interface;

import Exceptions.PublisherException;

import java.util.UUID;

public interface Publisher {
    void registerWithBroker() throws PublisherException;
    void deregisterWithBroker() throws PublisherException;
    void sendMessageOnBroker(String msg, String type) throws PublisherException;
    UUID getId();
}
