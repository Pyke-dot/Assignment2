package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    ListView purchaseHistory;
    ArrayList purchasedProducts;
    PurchaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        purchaseHistory = findViewById(R.id.allpurchase);
        purchasedProducts = ((MyApp)getApplication()).currentPurchase;

        adapter = new PurchaseAdapter(this,purchasedProducts);
        purchaseHistory.setAdapter(adapter);

        Intent intent = new Intent(this, Details.class);
        purchaseHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                intent.putExtra("detail", Purchase.display((Purchase)purchasedProducts.get(i)));
                startActivity(intent);
            }
        });


    }
}