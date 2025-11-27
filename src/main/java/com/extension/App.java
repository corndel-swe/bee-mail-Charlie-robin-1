package com.extension;

import java.util.*;

public class App implements MessageMediator {

    private static App instance;
    private final List<User> users;
    private final User ADMIN = new User("0", "ADMIN");
    private final Map<String, List<User>> groups;

    private App() {
        this.users = new ArrayList<>();
        this.groups = new HashMap<>();
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

    public void addUser(String groupId, User user) {
        groups.computeIfAbsent(groupId, k -> new ArrayList<>()).add(user);
    }

    @Override
    public void deliverMessage(String senderId, String recipientId, String content) {
        Optional<User> sender = findUser(senderId);
        Optional<User> recipient = findUser(recipientId);
        List<User> group = groups.getOrDefault(recipientId, List.of());

        if (sender.isEmpty()) {
            System.out.println("Cannot find sender :S");
            return;
        }

        if (group.isEmpty() && recipient.isEmpty()) {
            Message unableToFindRecipient = new Message(ADMIN, sender.get(), "Failed message to :" + recipientId);
            sender.get().receiveMessage(unableToFindRecipient);
            return;
        }

        if (!group.isEmpty()) {
            group.forEach(user -> {
                Message message = new Message(sender.get(), user, content);
                user.receiveMessage(message);
            });
        } else {
            Message message = new Message(sender.get(), recipient.get(), content);
            recipient.get().receiveMessage(message);
        }
    }
}
