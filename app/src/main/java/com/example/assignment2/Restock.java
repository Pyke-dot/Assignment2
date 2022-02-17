package com.example.assignment2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Restock extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Items> item_list;
    Button ok_btn;
    Button no_btn;
    ItemListBaseAdapter adapter;
    Items selectedItem;
    EditText stock_text;
    ListView stocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        item_list = ((MyApp) getApplication()).item_list;
        ok_btn = findViewById(R.id.yes_Btn);
        ok_btn.setOnClickListener(this);
        no_btn = findViewById(R.id.no_Btn);
        no_btn.setOnClickListener(this);
        stock_text = findViewById(R.id.stockText);
        stocks = findViewById(R.id.restock_list);
        adapter = new ItemListBaseAdapter(item_list, this);
        stocks.setAdapter(adapter);

        stocks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = item_list.get(i);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.no_Btn:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.yes_Btn:
                if(selectedItem != null && !stock_text.getText().toString().isEmpty())
                {
                    selectedItem.itemQuantity += Integer.parseInt(stock_text.getText().toString());
                    adapter = new ItemListBaseAdapter(item_list, this);
                    stocks.setAdapter(adapter);
                    stock_text.setText("");
                    selectedItem = null;
                }
                else
                {
                    Toast.makeText(Restock.this, "All fields are REQUIRED!!!", Toast.LENGTH_LONG).show();
                }
                break;


        }
    }
}
