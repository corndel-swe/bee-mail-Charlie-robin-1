package com.extension;

public interface MessageMediator {
    void deliverMessage(String senderId, String recipientId, String content);
    void addUser(User user);
}
