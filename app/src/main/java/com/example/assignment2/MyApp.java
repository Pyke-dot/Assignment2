package com.example.assignment2;

import android.app.Application;

import java.util.ArrayList;

public class MyApp extends Application {
    ArrayList<Items> item_list = new ArrayList<Items>(){
        {
            add(new Items(10,"pants",20.44));
            add(new Items(100,"Shoes",10.44));
            add(new Items(30,"hats",5.9));
        }
    };

    ArrayList<Purchase> currentPurchase = new ArrayList<>(0);
};
