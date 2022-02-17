package com.example.assignment2;


import java.util.Date;

public class Purchase  {
    int purchaseQuantity;
    double purchaseTotal;
    Date created;
    String productName;


    public Purchase(int purchaseQuantity,  String productName,double purchaseTotal, Date date){
        this.purchaseQuantity = purchaseQuantity;
        this.purchaseTotal = purchaseTotal;
        this.productName = productName;
        this.created = date;
    }

    public static String display(Purchase pur){
        return ("Product: " + pur.productName + "\n" + "Price: " + pur.purchaseTotal + "\n" + "Purchase Date: " + pur.created);
    }

}
