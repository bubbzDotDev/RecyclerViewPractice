package com.example.recyclerviewtakethree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Item {
    private String name;
    private String date;
    private int id;
    private Map item = new HashMap();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item(String name, String date) {
        this.name = name;
        this.date = date;

        // Add them to HashMap
        item.put("Name", name);
        item.put("Date", date);
    }

    public String getItem() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public static ArrayList<Item> createItemsList(Item item) {
        ArrayList<Item> itemsList = new ArrayList<Item>();
        itemsList.add(item);
        return itemsList;
    }
}