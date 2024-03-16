package com.example.fragmentapp.Data;

import com.example.fragmentapp.R;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private Integer image;
    private String name;


    static Integer[] images = {
            R.drawable.apple, R.drawable.banana, R.drawable.orange, R.drawable.carrot,
            R.drawable.broccoli, R.drawable.tomato, R.drawable.beef, R.drawable.chicken,
            R.drawable.fish, R.drawable.pork, R.drawable.egg,
    };

    static String[] names = {
            "Apple", "Banana", "Orange", "Carrot", "Broccoli", "Tomato",
            "Beef", "Chicken", "Fish", "Pork", "Egg", "Lamb"
    };


    private static List<Products> ProductList = new ArrayList<>();

    // Static initializer block to populate the grocery list
    static {
        for (int i = 0; i < images.length; i++) {
            ProductList.add(new Products(images[i], names[i]));
        }
    }

    public Products(Integer image, String name) {
        this.image = image;
        this.name = name;
    }


    // Getter methods
    public Integer getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    // Method to get the static list of groceries
    public static List<Products> getProductList() {
        return ProductList;
    }

}
