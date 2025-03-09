package com.near.Inventory_System.utils;


import lombok.experimental.UtilityClass;

import com.near.Inventory_System.service.Item;

import java.util.Map;

@UtilityClass
public class MyUtils {
    public static Integer idGenerator(Map<Integer, Item> stock, int maxId) {
        int newId = (int) (Math.random() * maxId);
        while(stock.containsKey(newId)) {
            newId = (int)  (Math.random() * maxId);
        }
        return newId;
    }
}
