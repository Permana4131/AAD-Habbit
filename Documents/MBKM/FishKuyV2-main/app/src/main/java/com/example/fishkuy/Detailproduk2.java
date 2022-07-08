package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Detailproduk2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailproduk2);
    }

    public void chat(View view) {
        Intent intent = new Intent(Detailproduk2.this, Chat.class);
        startActivity(intent);
    }

    public void beli3(View view) {
        Intent intent2 = new Intent(Detailproduk2.this, Menubeli2.class);
        startActivity(intent2);
    }

    public void keranjang(View view) {
        Intent intent3 = new Intent(Detailproduk2.this, Keranjang.class);
        startActivity(intent3);
    }

    public void back5(View view) {
        Intent intent4 = new Intent(Detailproduk2.this, Ikanlaut.class);
        startActivity(intent4);
    }
}