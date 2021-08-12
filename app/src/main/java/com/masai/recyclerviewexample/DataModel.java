package com.masai.recyclerviewexample;

public class DataModel {
    private String name;
    private String lastName;
    private int type;
    private String img;


    DataModel(String name, int type){
        this.name = name;
        this.type = type;
    }

    DataModel(String name, String lastName, int type, String image){
        this.name = name;
        this.lastName = lastName;
        this.type = type;
        this.img = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }




}
