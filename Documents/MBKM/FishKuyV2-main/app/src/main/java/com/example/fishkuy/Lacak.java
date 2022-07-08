package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lacak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lacak);
    }

    public void back22(View view) {
        Intent intent = new Intent(Lacak.this, Homescreen.class);
        startActivity(intent);
    }

    public void buttonselesai(View view) {
        Intent intent2 = new Intent(Lacak.this, Lacak2.class);
        startActivity(intent2);
    }
}