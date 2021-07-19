package com.example.fooddeliveryapp.HomeAdapters;

public class OrderFavHelperClass {
    int image;
    String title,desc,source;

    public OrderFavHelperClass(int image, String title, String desc, String source) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.source = source;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getSource() {
        return source;
    }
}
