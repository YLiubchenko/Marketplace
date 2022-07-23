package org.example;

import static org.example.Helper.generateID;

public class User {
    private String FirstName;
    private String LastName;
    private String AmountOfMoney;
    private String Id;
    private String Purchases;

    public User (String firstName, String lastName, String amountOfMoney, String purchases) {
        Id = generateID();
        FirstName = firstName;
        LastName = lastName;
        AmountOfMoney = amountOfMoney;
        Purchases = purchases;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        AmountOfMoney = amountOfMoney;
    }

    public String getPurchases() {
        return Purchases;
    }

    public void setPurchases(String purchases) {
        Purchases = purchases;
    }

    public String getAmountOfMoney() {
        return AmountOfMoney;
    }

    public String getId() {
        return Id;
    }
}