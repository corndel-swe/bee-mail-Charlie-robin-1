package com.beemail;


import java.time.LocalDate;
import java.util.UUID;

public class Message {
    private String id = UUID.randomUUID().toString();
    private final LocalDate timestamp = LocalDate.now();
    private final String content;
    private final User from;
    private final User to;
    private boolean delivered = false;
    private boolean read = false;

    public Message(User from, User to, String content) {
        this.content = content;
        this.from = from;
        this.to = to;
    }

    public void log() {
        String format = "| %-15s | %-30s |%n";
        System.out.format("+-----------------+--------------------------------+%n");
        System.out.format("| Field           | Value                          |%n");
        System.out.format("+-----------------+--------------------------------+%n");
        System.out.format(format, "Created", timestamp);
        System.out.format(format, "From", from.getUserName());
        System.out.format(format, "To", to.getUserName());
        System.out.format(format, "Content", content);
        System.out.format(format, "Delivered", delivered);
        System.out.format(format, "Read", read);
        System.out.format("+-----------------+--------------------------------+%n");
    }

    public void markDelivered() {
        delivered = true;
    }

    public Message markRead() {
        read = true;
        return this;
    }
}
