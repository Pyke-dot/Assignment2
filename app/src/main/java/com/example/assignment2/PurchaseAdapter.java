package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class PurchaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<Purchase> purchaseArrayList;


    public PurchaseAdapter(Context appContext, ArrayList<Purchase> list){
        this.context = appContext;
        this.purchaseArrayList = list;
    }

    @Override
    public int getCount() {
        return purchaseArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return purchaseArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_list,null);
        TextView itemName = view.findViewById(R.id.name_row_id);
        TextView totalPrice = view.findViewById(R.id.quantity_row_id);
        TextView quantity = view.findViewById(R.id.price_row_id);
        itemName.setText(purchaseArrayList.get(i).productName);
        quantity.setText(Integer.toString(purchaseArrayList.get(i).purchaseQuantity));
        totalPrice.setText(Double.toString(purchaseArrayList.get(i).purchaseTotal));

        return view;
    }
}
