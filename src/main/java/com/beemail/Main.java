package com.beemail;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        App app = App.getInstance();

        User charlie = new User("123", "Charlie");
        User violet = new User("456", "Violet");
        User mike = new User("789", "Mike");

        charlie.addUser(app);
        violet.addUser(app);
        mike.addUser(app);

        charlie.sendMessage("456", "Hello");

        violet.readMessage(0);

        violet.sendMessage("123", "Hey");
        charlie.readMessage(0);
    }
}
