package com.near.Inventory_System.service;

import org.springframework.stereotype.Service;

@Service
public class Item {
    private String item;
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
