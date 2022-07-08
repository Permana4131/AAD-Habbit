package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ikanlaut extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuikan_laut);
    }

    public void beli2(View view) {
        Intent intent = new Intent(Ikanlaut.this, Detailproduk2.class);
        startActivity(intent);
    }

    public void back5(View view) {
        Intent intent2 = new Intent(Ikanlaut.this, Homescreen.class);
        startActivity(intent2);
    }

    public void chat(View view) {
        Intent intent5 = new Intent(Ikanlaut.this, Chat.class);
        startActivity(intent5);
    }

    public void keranjang(View view) {
        Intent intent9 = new Intent(Ikanlaut.this, Keranjang.class);
        startActivity(intent9);
    }

    public void lacak(View view) {
        Intent intent = new Intent(Ikanlaut.this, Lacak.class);
        startActivity(intent);
    }
}
