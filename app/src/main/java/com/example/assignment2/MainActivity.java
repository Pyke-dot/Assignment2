package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buy;
    Button manager;

    int selectedValue;

    AlertDialog.Builder builder;

    private TextView picker;
    private TextView subtotalView;
    private TextView productName;

    ListView itemList;
    ArrayList<Items> items;
    Items selectedItem;
    ItemListBaseAdapter adapter;

    Purchase currentPurchased;


    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(this);


        picker = findViewById(R.id.textViewNumberPicker);
        productName = findViewById(R.id.SelectedItem);
        subtotalView = findViewById(R.id.subtotal);
        itemList = findViewById(R.id.item_list);

        //gets item list
        items = ((MyApp) getApplication()).item_list;
        //displaying item list
        adapter = new ItemListBaseAdapter(items, this);
        itemList.setAdapter(adapter);
        //manager&buy button
        manager = findViewById(R.id.ManagerBtn);
        manager.setOnClickListener(this);
        buy = findViewById(R.id.BuyBtn);
        buy.setOnClickListener(this);

        //Number picker
        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(0);
        numberPicker.setValue(0);


        //Number Picker onclick listener
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newVal) {
                selectedValue = numberPicker.getValue();
                picker.setText("" + newVal);
                if (selectedValue != 0 && selectedItem != null) {
                    subtotalView.setText(String.valueOf(df.format(selectedValue * selectedItem.itemPrice)));
                }
            }
        });
        //item list onclick listener
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                selectedItem = items.get(i);
                productName.setText(selectedItem.itemName);
                if (selectedValue != 0) {
                    subtotalView.setText(String.valueOf(df.format(selectedValue * selectedItem.itemPrice)));
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.ManagerBtn:
                //start manager activity
                Intent managerIntent = new Intent(this, Manager.class);
                startActivity(managerIntent);
                break;
            case R.id.BuyBtn:
                if (picker.getText().equals("0") || picker.getText().length() == 0 || productName.getText().equals("Product Type")) {
                    Toast.makeText(this, "All fields are required!!!", Toast.LENGTH_LONG).show();
                } else if (selectedValue > selectedItem.itemQuantity) {
                    Toast.makeText(this, "Not enough quantity in the stock!!!", Toast.LENGTH_LONG).show();
                } else {

                    currentPurchased = new Purchase(selectedValue,selectedItem.itemName,Double.parseDouble((String) subtotalView.getText()),new Date());
                    selectedItem.itemQuantity = selectedItem.itemQuantity - selectedValue;
                    setUI();

                    ((MyApp)getApplication()).currentPurchase.add(currentPurchased);

                    adapter = new ItemListBaseAdapter(items,this);
                    itemList.setAdapter(adapter);

                    builder.setTitle("Thank You for your purchase");
                    builder.setMessage("your purchase is " + currentPurchased.purchaseQuantity + " " + currentPurchased.productName + " for " +  currentPurchased.purchaseTotal);
                    builder.setCancelable(true);
                    builder.show();
                }
                break;
        }
    }
    public void setUI(){
        selectedValue = 0;
        selectedItem = null;
        productName.setText(R.string.item_name);
        picker.setText(R.string.numberPickerText);
        subtotalView.setText(R.string.subtotal);
    }
}