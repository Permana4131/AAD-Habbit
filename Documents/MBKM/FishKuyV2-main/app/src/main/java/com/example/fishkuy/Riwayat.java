package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Riwayat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);
    }

    public void back13(View view) {
        Intent intent = new Intent(Riwayat.this, Homescreen.class);
        startActivity(intent);
    }

    public void diproses(View view) {
        Intent intent2 =new Intent( Riwayat.this, Riwayat.class);
        startActivity(intent2);
    }

    public void selesai(View view) {
        Intent intent3 = new Intent(Riwayat.this, Riwayat2.class);
        startActivity(intent3);
    }

    public void chat5(View view) {
        Intent intent4 =new Intent(Riwayat.this, Chat.class);
        startActivity(intent4);
    }

    public void lacak(View view) {
        Intent intent5 = new Intent(Riwayat.this, Lacak.class);
        startActivity(intent5);
    }

    public void chat6(View view) {
        Intent intent6 = new Intent(Riwayat.this, Chat.class);
        startActivity(intent6);
    }

    public void lacak2(View view) {
        Intent intent7 = new Intent(Riwayat.this, Lacak.class);
        startActivity(intent7);
    }
}