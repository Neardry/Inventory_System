package com.near.Inventory_System.service;

import org.springframework.stereotype.Service;
import com.near.Inventory_System.utils.MyUtils;

import java.util.*;

@Service
public class Deposit {

    private int maxIdNumbers = 50000;

    private ArrayList<String> allInitialItems = new ArrayList<String>(
    Arrays.asList(
        "Chave inglesa",
        "Macaco hidráulico",
        "Chave de roda",
        "Serrinha para metal",
        "Martelo de borracha",
        "Alicate",
        "Trena",
        "Cinta de amarração",
        "Óleo de motor",
        "Furos para pneu",
        "Esticador de corrente",
        "Balanceadora de rodas",
        "Máquina de solda",
        "Lixadeira",
        "Kit de ferramentas automotivas",
        "Lanterna",
        "Mangueira de combustível",
        "Bateria automotiva",
        "Pneus",
        "Pastilhas de freio",
        "Filtros de ar e óleo"
));
    
    public ArrayList<String> getItems() {
        return allInitialItems;
    }

    public void pushItem(String arg) {
        allInitialItems.add(arg);
    }

    public void removeItem(String arg) {
        if(allInitialItems.contains(arg)) {
            allInitialItems.remove(arg);
            return;
        }
        throw new Error("O argumento '" + arg + "' não foi encontrado no BD");
    }

    private Map<Integer, Item> stock = new HashMap<>();
    
    public Deposit() {
        for(int i = 0; i<allInitialItems.size(); i++) {
            int newId = MyUtils.idGenerator(stock, maxIdNumbers);
            Item newItem = new Item(allInitialItems.get(i), 0);
            stock.put(newId, newItem);
        }
    }

    public String depositList() {
        String text = "";
        for(Map.Entry<Integer, Item> entry : stock.entrySet()) {
            text += " ID: " + entry.getKey() + "\n Item: " + entry.getValue().getItem() + "\n Quantidade: " + entry.getValue().getQuantity() + "\n ------------------------------\n";
        }
        return text;
    }

    public void pushItemStock(String item) {
        if(stock.values().stream().anyMatch(i -> i.getItem().equals(item))) {
            throw new Error("Este item já está em sua base de dados");
        }
        stock.put(MyUtils.idGenerator(stock, maxIdNumbers), new Item(item, 0));
    }

}
