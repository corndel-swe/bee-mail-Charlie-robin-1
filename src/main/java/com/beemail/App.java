package com.beemail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App implements MessageMediator {

    private static App instance;
    private final List<User> users;
    private final User ADMIN = new User("0", "ADMIN");

    private App() {
        this.users = new ArrayList<>();
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public Optional<User> findUser(String userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deliverMessage(String senderId, String recipientId, String content) {
        Optional<User> sender = findUser(senderId);
        Optional<User> recipient = findUser(recipientId);

        if (sender.isEmpty()) {
            System.out.println("Cannot find sender :S");
            return;
        }

        if (recipient.isEmpty()) {
            Message unableToFindRecipient = new Message(ADMIN, sender.get(), "Failed to Deliver message to :" + recipientId);
            sender.get().receiveMessage(unableToFindRecipient);
            return;
        }

        Message message = new Message(sender.get(), recipient.get(), content);
        recipient.get().receiveMessage(message);
    }


}
