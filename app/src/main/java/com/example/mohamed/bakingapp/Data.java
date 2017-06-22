package com.example.mohamed.bakingapp;

/**
 * Created by mohamed on 5/28/2017.
 */

public class Data {
    private String recipName ;
    private int recipImg ;
    Data(String recipName,int recipImg){
        this.recipName = recipName;
        this.recipImg = recipImg;
    }

    public String getRecipName() {
        return recipName;
    }

    public void setRecipName(String recipName) {
        this.recipName = recipName;
    }

    public int getRecipImg() {
        return recipImg;
    }

    public void setRecipImg(int recipImg) {
        this.recipImg = recipImg;
    }
}
