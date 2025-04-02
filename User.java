package models;

public class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("\nCustomer Information:");
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
    }
    }

