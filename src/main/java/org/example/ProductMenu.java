package org.example;

import java.util.ArrayList;

public class ProductMenu {
    private static final ArrayList<Product> productList = new ArrayList<>();
    private final String[] productMenuList = {"Add product - 1", "Show product - 2", "Delete product - 3", "Back - 0"};
    StoreMenu storeMenu = new StoreMenu();
    UsersMenu usersMenu = new UsersMenu();
    static ProductMenu productMenu = new ProductMenu();

    public void addProduct() {
        String name = Helper.inputAnswer("Enter Product name");
        String price = Helper.inputNumber("Enter price");

        productList.add(new Product(name, price));
    }

    public static void showProducts() {
        for (Product product : productList) {
            productMenu.showProduct(product);
        }
    }

    public void showProduct (Product product) {
        System.out.println("Id: " + product.getId());
        System.out.println("Product name: " + product.getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("-------------------------------------------");
    }

    public void removeProduct() {
        System.out.println("Please, Enter product id");
        String productId = storeMenu.getScannerValueStr();

        if (!productId.isEmpty()) {
            System.out.println("Are you sure you want to delete this product? (y/n)");
            String result = storeMenu.getScannerValueStr();

            if (result.equalsIgnoreCase("y")) {
                float price = getCurrentProductPrice(productId);
                refundMoney(price, productId);
                System.out.println("Product with " + productId + " is removed!");
            }
        }
    }

    public float getCurrentProductPrice(String productId) {
        float price = 0;

        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId().equals(productId)) {
                price = Float.parseFloat(product.getPrice());
                productList.remove(i);
                break;
            }
        }

        return price;
    }

    public void refundMoney (float price, String productId) {
        for (User user : usersMenu.getUserList()) {
            String purchases = user.getPurchases();
            float money = Float.parseFloat(user.getAmountOfMoney());
            String newPurchases = purchases.replace(productId, "");

            money += price * (purchases.length() - newPurchases.length()) / productId.length();

            user.setAmountOfMoney(String.valueOf(money));
            user.setPurchases(newPurchases);
        }
    }

    public void productAction(int action) {
        switch (action) {
            case 1:
                addProduct();
                break;
            case 2:
                showProducts();
                break;
            case 3:
                removeProduct();
                break;
        }
    }

    public String[] getProductMenuList() {
        return productMenuList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

}