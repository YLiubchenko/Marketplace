package org.example;

import java.util.ArrayList;

public class UsersMenu {
    private final ArrayList<User> userList = new ArrayList<>();
    private final String[] userMenuList = {"Add user - 1", "Show user - 2", "Delete user - 3", "Back - 0"};
    StoreMenu main = new StoreMenu();

    public void addUser() {
        String firstName = setAnswer("Enter First name");
        String lastName = setAnswer("Enter Last name");
        String amountOfMoney = setMoney();

        userList.add(new User(firstName, lastName, amountOfMoney));
    }

    private String setAnswer(String question) {
        String answer = "";

        while (answer.isEmpty()) {
            System.out.println(question);
            answer = main.getScannerValueStr();
        }

        return answer;
    }

    private String setMoney() {
        String answer = "";
        String question = "Enter Amount of money";

        while (answer.isEmpty()) {
            System.out.println(question);
            String scannerAnswer = main.getScannerValueStr();

            float priceFloat = scannerAnswer.chars().allMatch(Character::isDigit) ? Float.parseFloat(scannerAnswer) : -1;

            if (priceFloat < 0) {
                question = "Please, enter a positive number!";
            } else {
                answer = String.valueOf(priceFloat);
            }
        }

        return answer;
    }

    public void showUsers() {
        for (User user : userList) {
            System.out.println("Id: " + user.getId());
            System.out.println("Firs name: " + user.getFirstName());
            System.out.println("Last name: " + user.getLastName());
            System.out.println("Amount of money: " + user.getAmountOfMoney());
            System.out.println("-------------------------------------------");
        }
    }

    public void removeUser() {
        System.out.println("Please, Enter user id");
        String userId = main.getScannerValueStr();

        if (!userId.isEmpty()) {
            System.out.println("Are you sure you want to delete this user? (y/n)");
            String result = main.getScannerValueStr();

            if (result.equalsIgnoreCase("y")) {
                userList.removeIf(user -> user.getId().equals(userId));
                System.out.println("User with " + userId + " is removed!");
            }
        }
    }

    public void userAction (int action) {
        switch (action) {
            case 1:
                addUser();
                break;
            case 2:
                showUsers();
                break;
            case 3:
                removeUser();
                break;
        }
    }

    public String[] getUserMenuList() {
        return userMenuList;
    }
}