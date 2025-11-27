package com.beemail;

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

        // USER1 MESSAGE USER2
        charlie.sendMessage("456", "Hello");
        peter.readMessage(0);

        // USER2 MESSAGE USER1
        peter.sendMessage("123", "Hey");
        charlie.readMessage(0);

        // USER3 EDGE CASES
        simon.readMessage(0);
        simon.sendMessage("101112", "Howdy");
        simon.readMessage(0);
        simon.readMessage(2);
    }
}
