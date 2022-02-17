package com.example.assignment2;

import android.os.Parcel;
import android.os.Parcelable;

public class Items {
    int itemQuantity;
    double itemPrice;
    String itemName;

    public Items(int quantity, String name, double price) {
        itemPrice = price;
        itemQuantity = quantity;
        itemName = name;
    }



}
