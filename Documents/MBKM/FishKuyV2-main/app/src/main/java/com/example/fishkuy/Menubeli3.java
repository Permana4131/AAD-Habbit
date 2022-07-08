package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menubeli3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubeli3);
    }

    public void back12(View view) {
        Intent intent = new Intent(Menubeli3.this, Detailproduk3.class);
        startActivity(intent);
    }

    public void bayar4(View view) {
        Intent intent2 = new Intent(Menubeli3.this, Transaksiberhasil.class);
        startActivity(intent2);
    }
}