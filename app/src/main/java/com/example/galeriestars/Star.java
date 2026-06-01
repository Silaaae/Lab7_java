package com.example.galeriestars;

public class Star {
    private String name;
    private String category;
    private float rating;
    private int imageRes;

    public Star(String name, String category, float rating, int imageRes) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.imageRes = imageRes;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public float getRating() { return rating; }
    public int getImageRes() { return imageRes; }
}
