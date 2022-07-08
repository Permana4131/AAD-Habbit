package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menubeli2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubeli2);
    }

    public void bayar2(View view) {
        Intent intent = new Intent(Menubeli2.this, Transaksiberhasil.class);
        startActivity(intent);
    }

    public void back21(View view) {
        Intent intent2 = new Intent(Menubeli2.this, Homescreen.class);
        startActivity(intent2);
    }
}