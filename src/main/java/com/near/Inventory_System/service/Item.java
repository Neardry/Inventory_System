package com.near.Inventory_System.service;


public class Item {
    private final String item;
    private int quantity;

    public Item(String a, int b) {
        this.item = a;
        this.quantity = b;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int argQuantity) {
        this.quantity = argQuantity;
    }

    public String toString() {
        return item + ": " + quantity;
    }
}
