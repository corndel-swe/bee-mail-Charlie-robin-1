package com.beemail;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    private final String userName;
    private final List<Message> inbox = new ArrayList<>();
    private MessageMediator messageMediator;

    public User(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public void addUser(MessageMediator messageMediator) {
        messageMediator.addUser(this);
        setMessageMediator(messageMediator);
    }

    public void sendMessage(String recipientId, String content) {
        messageMediator.deliverMessage(id, recipientId, content);
    }

    public void receiveMessage(Message message) {
        inbox.add(message);
        message.markDelivered();
    }

    public void readMessage(int index) {
        inbox.get(index).markRead().log();
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setMessageMediator(MessageMediator messageMediator) {
        this.messageMediator = messageMediator;
    }
}
