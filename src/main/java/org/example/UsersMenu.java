package org.example;

import java.util.ArrayList;

public class UsersMenu {
    private static final ArrayList<User> userList = new ArrayList<>();
    private final String[] userMenuList = {"Add user - 1", "Show user - 2", "Delete user - 3", "Back - 0"};
    StoreMenu storeMenu = new StoreMenu();
    static UsersMenu usersMenu = new UsersMenu();

    public void addUser() {
        String firstName = Helper.inputAnswer("Enter First name");
        String lastName = Helper.inputAnswer("Enter Last name");
        String amountOfMoney = Helper.inputNumber("Enter Amount of money");

        userList.add(new User(firstName, lastName, amountOfMoney, ""));
    }

    public static void showUsers() {
        for (User user : userList) {
            usersMenu.showUser(user);
        }
    }

    public void showUser(User user) {
        System.out.println("Id: " + user.getId());
        System.out.println("Firs name: " + user.getFirstName());
        System.out.println("Last name: " + user.getLastName());
        System.out.println("Amount of money: " + user.getAmountOfMoney());
        System.out.println("-------------------------------------------");
    }

    public void removeUser() {
        System.out.println("Please, Enter user id");
        String userId = storeMenu.getScannerValueStr();

        if (!userId.isEmpty()) {
            System.out.println("Are you sure you want to delete this user? (y/n)");
            String result = storeMenu.getScannerValueStr();

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

    public ArrayList<User> getUserList() {
        return userList;
    }
}