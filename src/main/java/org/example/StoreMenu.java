package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UsersMenu userMenu = new UsersMenu();

    public static void main(String[] args) {
        String[] menu = {"User menu - 1", "Product menu - 2", "Finish - 0"};
        int result = -1;
        int close = 0;

        while (result != close) {
            showOptions(menu);
            showMessage();
            result = getScannerValue();

            switch (result) {
                case 1:
                    showUserMenu();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }

    public static void showUserMenu() {
        int value = -1;
        int back = 0;

        while (value != back) {
            showOptions(userMenu.getUserMenuList());
            showMessage();

            value = getScannerValue();

            userMenu.userAction(value);
        }
    }

    public static void showOptions(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public static void showMessage() {
        System.out.println("Please, Enter number from list above");
    }

    public static int getScannerValue() {
        String str = new Main().getScannerValueStr();

        if (!str.isEmpty() && str.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(str);
        }

        return -1;
    }

    public String getScannerValueStr() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine().strip();
        }

        return "";
    }
}