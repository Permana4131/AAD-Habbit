package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Riwayat2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat2);
    }

    public void back14(View view) {
        Intent intent =new Intent(Riwayat2.this, Homescreen.class);
        startActivity(intent);
    }

    public void diproses2(View view) {
        Intent intent2 =new Intent(Riwayat2.this, Riwayat.class);
        startActivity(intent2);
    }

    public void selesai2(View view) {
        Intent intent3 =new Intent(Riwayat2.this, Riwayat2.class);
        startActivity(intent3);
    }

}