package org.example;

import static org.example.Helper.generateID;

public class Product {
    private final String Name;
    private final String Price;
    private final String Id;

    public Product(String name, String price) {
        Name = name;
        Price = price;
        Id = generateID();
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public String getId() {
        return Id;
    }
}