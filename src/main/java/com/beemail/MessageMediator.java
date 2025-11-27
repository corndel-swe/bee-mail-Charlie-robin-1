package com.beemail;

public interface MessageMediator {
    void deliverMessage(String senderId, String recipientId, String content);

    void addUser(User user);
}
