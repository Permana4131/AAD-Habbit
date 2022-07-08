package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ikantawar extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuikan_tawar);
    }

    public void back5(View view) {
        Intent intent = new Intent(Ikantawar.this, Homescreen.class);
        startActivity(intent);
    }

    public void beli5(View view) {
        Intent intent2 = new Intent(Ikantawar.this, Detailproduk.class);
        startActivity(intent2);
    }

    public void chat(View view) {
        Intent intent5 = new Intent(Ikantawar.this, Chat.class);
        startActivity(intent5);
    }

    public void keranjang(View view) {
        Intent intent9 = new Intent(Ikantawar.this, Keranjang.class);
        startActivity(intent9);
    }

    public void lacak(View view) {
        Intent intent = new Intent(Ikantawar.this, Lacak.class);
        startActivity(intent);
    }
}
