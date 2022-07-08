package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Transaksiberhasil extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_berhasil);
    }

    public void home2(View view) {
        Intent intent = new Intent(Transaksiberhasil.this, Homescreen.class);
        startActivity(intent);
    }
}
