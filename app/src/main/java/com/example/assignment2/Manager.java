package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Manager extends AppCompatActivity implements View.OnClickListener {

    Button history, restock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        history = findViewById(R.id.historyBtn);
        history.setOnClickListener(this);
        restock = findViewById(R.id.restockBtn);
        restock.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.historyBtn:
                Intent myIntent = new Intent(this, History.class);
                startActivity(myIntent);
                break;
            case R.id.restockBtn:
                Intent intent = new Intent(this, Restock.class);
                startActivity(intent);
                break;
        }
    }
}