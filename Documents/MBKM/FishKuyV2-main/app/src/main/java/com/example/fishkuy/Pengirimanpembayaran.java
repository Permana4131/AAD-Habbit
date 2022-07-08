package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pengirimanpembayaran extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengiriman_pembayaran);
    }

    public void bayar(View view) {
        Intent intent = new Intent(Pengirimanpembayaran.this, Transaksiberhasil.class);
        startActivity(intent);
    }

    public void back25(View view) {
        Intent intent2 = new Intent(Pengirimanpembayaran.this, Keranjang.class);
        startActivity(intent2);
    }
}
