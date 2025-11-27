package com.extension;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        App app = App.getInstance();

        User charlie = new User("123", "Charlie");
        User peter = new User("456", "Peter");
        User simon = new User("789", "Simon");

        charlie.addUser(app);
        peter.addUser(app);
        simon.addUser(app);

        app.addUser("group-1", charlie);
        app.addUser("group-1", peter);
        app.addUser("group-1", simon);

        simon.sendMessage("group-1", "Whaaaaattttssss uuuuppppp!!!!");

        charlie.readMessage(0);
        peter.readMessage(0);
        simon.readMessage(0);
    }
}
