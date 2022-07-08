package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menubeli extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_beli);
    }

    public void back9(View view) {
        Intent intent = new Intent(Menubeli.this, Detailproduk.class);
        startActivity(intent);
    }

    public void bayar3(View view) {
        Intent intent2 = new Intent(Menubeli.this, Transaksiberhasil.class);
        startActivity(intent2);
    }
}
