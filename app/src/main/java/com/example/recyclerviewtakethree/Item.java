package com.example.recyclerviewtakethree;

import java.util.ArrayList;

public class Item {
    private String item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Item(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public static ArrayList<Item> createItemsList(Item item) {
        ArrayList<Item> itemsList = new ArrayList<Item>();
        itemsList.add(item);
        return itemsList;
    }
}