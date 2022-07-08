package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Detailproduk3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailproduk3);
    }

    public void back5(View view) {
        Intent intent = new Intent(Detailproduk3.this, Seafood.class);
        startActivity(intent);
    }

    public void chat4(View view) {
        Intent intent2 = new Intent(Detailproduk3.this, Chat.class);
        startActivity(intent2);
    }

    public void beli7(View view) {
        Intent intent3 = new Intent(Detailproduk3.this, Menubeli3.class);
        startActivity(intent3);
    }

    public void keranjang4(View view) {
        Intent intent4 = new Intent(Detailproduk3.this, Keranjang.class);
        startActivity(intent4);
    }
}