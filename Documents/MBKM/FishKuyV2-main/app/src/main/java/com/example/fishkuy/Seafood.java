package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Seafood extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_seafood);
    }

    public void back5(View view) {
        Intent intent = new Intent(Seafood.this, Homescreen.class);
        startActivity(intent);
    }

    public void beli6(View view) {
        Intent intent2 = new Intent(Seafood.this, Detailproduk3.class);
        startActivity(intent2);
    }

    public void chat(View view) {
        Intent intent5 = new Intent(Seafood.this, Chat.class);
        startActivity(intent5);
    }

    public void keranjang(View view) {
        Intent intent9 = new Intent(Seafood.this, Keranjang.class);
        startActivity(intent9);
    }

    public void lacak(View view) {
        Intent intent = new Intent(Seafood.this, Lacak.class);
        startActivity(intent);
    }
}
