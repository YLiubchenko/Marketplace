package org.example;

public class User {
    private String FirstName;
    private String LastName;
    private String AmountOfMoney;
    private String Id;

    public User (String firstName, String lastName, String amountOfMoney) {
        Id = String.valueOf(System.currentTimeMillis() / 1000L);
        FirstName = firstName;
        LastName = lastName;
        AmountOfMoney = amountOfMoney;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAmountOfMoney() {
        return AmountOfMoney;
    }

    public String getId() {
        return Id;
    }
}