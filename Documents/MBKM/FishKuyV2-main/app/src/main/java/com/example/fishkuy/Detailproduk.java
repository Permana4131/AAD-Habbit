package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Detailproduk extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detailproduk);
    }

    public void chat3(View view) {
        Intent intent = new Intent(Detailproduk.this, Chat.class);
        startActivity(intent);
    }

    public void beli4(View view) {
        Intent intent2 = new Intent(Detailproduk.this, Menubeli.class);
        startActivity(intent2);
    }

    public void keranjang3(View view) {
        Intent intent3 = new Intent(Detailproduk.this, Keranjang.class);
        startActivity(intent3);
    }

    public void back5(View view) {
        Intent intent4 = new Intent(Detailproduk.this, Ikantawar.class);
        startActivity(intent4);

    }
}
