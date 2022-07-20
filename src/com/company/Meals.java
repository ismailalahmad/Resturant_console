package com.company;

public class Meals {
    private String id;
    private String title;
    private String[] anyArray;

    public Meals(String id, String title, String[] anyArray) {
        this.id = id;
        this.title = title;
        this.anyArray = anyArray;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String[] getAnyArray() {
        return anyArray;
    }
}
