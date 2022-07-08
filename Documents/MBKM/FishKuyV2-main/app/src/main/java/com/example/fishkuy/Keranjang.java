package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Keranjang extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_keranjang);
    }

    public void beli(View view) {
        Intent intent = new Intent(Keranjang.this, Pengirimanpembayaran.class);
        startActivity(intent);
    }

    public void back24(View view) {
        Intent intent2 = new Intent(Keranjang.this, Homescreen.class);
        startActivity(intent2);
    }
}
