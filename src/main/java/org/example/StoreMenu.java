package org.example;

import java.util.*;
import java.util.stream.Stream;


public class StoreMenu {
    static Scanner scanner = new Scanner(System.in);
    static UsersMenu userMenu = new UsersMenu();
    static ProductMenu productMenu = new ProductMenu();
    static StoreMenu storeMenu = new StoreMenu();

    public static void init() {

        String[] menu = {"User menu - 1", "Product menu - 2", "Show all users - 3", "Show all products - 4", "Buy product - 5", "Show products by user id - 6", "Show users by product id - 7", "Finish - 0"};
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
                    showProductMenu();
                    break;
                case 3:
                    UsersMenu.showUsers();
                    break;
                case 4:
                    ProductMenu.showProducts();
                    break;
                case 5:
                    buyProduct();
                    break;
                case 6:
                    showProductsByUserId();
                    break;
                case 7:
                    showUserByProductId();
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

    public static void showProductMenu() {
        int value = -1;
        int back = 0;

        while (value != back) {
            showOptions(productMenu.getProductMenuList());
            showMessage();

            value = getScannerValue();

            productMenu.productAction(value);
        }
    }

    public static void showProductsByUserId() {
        String userId = Helper.inputAnswer("Please, Enter user id.");
        String[] purchases = null;

        for (int i = 0; i < userMenu.getUserList().size(); i++) {
            User user = userMenu.getUserList().get(i);

            if (user.getId().equals(userId)) {
                purchases = user.getPurchases().split(" ");
                break;
            }
        }

        if (purchases != null) {
            for (Product product : productMenu.getProductList()) {
                if (Arrays.asList(purchases).contains(product.getId())) {
                    productMenu.showProduct(product);
                }
            }
        }
    }

    public static void showUserByProductId() {
        String productId = Helper.inputAnswer("Please, Enter product id.");
        for (User user : userMenu.getUserList()) {
            String[] purchases = user.getPurchases().split(" ");

            if (Arrays.asList(purchases).contains(productId)) {
                userMenu.showUser(user);
            }
        }
    }

    public static void showOptions(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    private static void showMessage() {
        System.out.println("Please, Enter number from list above");
    }

    public static int getScannerValue() {
        String str = storeMenu.getScannerValueStr();

        if (!str.isEmpty() && str.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(str);
        }

        return -1;
    }

    private static void buyProduct() {
        User userInfo = null;
        Product productInfo = null;

        while (userInfo == null) {
            String userId = Helper.inputAnswer("Please, enter user id");

            for (User user : userMenu.getUserList()) {
                if (user.getId().equals(userId)) {
                    userInfo = user;

                    break;
                }
            }
        }

        while (productInfo == null) {
            String productId = Helper.inputAnswer("Please, enter product id");

            for (Product product : productMenu.getProductList()) {
                if (product.getId().equals(productId)) {
                    productInfo = product;

                    break;
                }
            }
        }


        float userMoney = Float.parseFloat(userInfo.getAmountOfMoney()) - Float.parseFloat(productInfo.getPrice());
        String message = "You don't have enough money.";

        if (userMoney >= 0) {
            String purchases = userInfo.getPurchases() + " " + productInfo.getId();

            userInfo.setAmountOfMoney(String.valueOf(userMoney));
            userInfo.setPurchases(purchases);
            message = "Your purchase is successful.";
        }

        System.out.println(message);
    }

    public String getScannerValueStr() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine().strip();
        }

        return "";
    }
}