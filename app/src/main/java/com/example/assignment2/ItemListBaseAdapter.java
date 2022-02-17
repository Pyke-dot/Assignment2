package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListBaseAdapter extends BaseAdapter {

    ArrayList<Items> listOfItems;
    Context context;

    public ItemListBaseAdapter(ArrayList<Items> listOfItems,Context context) {
        this.listOfItems = listOfItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listOfItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.item_list,null);
        TextView itemName = view.findViewById(R.id.name_row_id);
        TextView itemQuantity = view.findViewById(R.id.quantity_row_id);
        TextView itemPrice = view.findViewById(R.id.price_row_id);
        itemName.setText(listOfItems.get(i).itemName);
        itemPrice.setText(Double.toString(listOfItems.get(i).itemPrice));
        itemQuantity.setText(Integer.toString(listOfItems.get(i).itemQuantity));
        return view;


    }
}
