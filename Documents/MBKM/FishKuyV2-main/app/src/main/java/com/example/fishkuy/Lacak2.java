package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lacak2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lacak2);
    }

    public void back22(View view) {
        Intent intent = new Intent(Lacak2.this, Homescreen.class);
        startActivity(intent);
    }

    public void diproses(View view) {
        Intent intent = new Intent(Lacak2.this, Lacak.class);
        startActivity(intent);
    }
}