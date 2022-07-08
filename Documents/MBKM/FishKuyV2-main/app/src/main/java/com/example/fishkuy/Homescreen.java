package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Homescreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
    }



    public void ikanLaut(View view) {
        Intent intent2 = new Intent(Homescreen.this, Ikanlaut.class);
        startActivity(intent2);
    }

    public void ikanTawar(View view) {
        Intent intent3 = new Intent(Homescreen.this, Ikantawar.class);
        startActivity(intent3);
    }

//    public void ikanPayau(View view) {
//        Intent intent4 = new Intent(Homescreen.this, )
//    }

    public void seafood(View view) {
        Intent intent4 = new Intent(Homescreen.this, Seafood.class);
        startActivity(intent4);
    }

//    public void resep(View view) {
//        Intent intent5 = new Intent(Homescreen.this, )
//    }

    public void chat(View view) {
        Intent intent5 = new Intent(Homescreen.this, Chat.class);
        startActivity(intent5);
    }

    public void keranjang(View view) {
        Intent intent9 = new Intent(Homescreen.this, Keranjang.class);
        startActivity(intent9);
    }

    public void lacak(View view) {
        Intent intent = new Intent(Homescreen.this, Lacak.class);
        startActivity(intent);
    }

    public void riwayat(View view) {
        Intent intent6 = new Intent(Homescreen.this, Riwayat.class);
        startActivity(intent6);
    }

    public void home(View view) {
        Intent intent7 = new Intent(Homescreen.this, Homescreen.class);
        startActivity(intent7);
    }

    public void profile(View view) {
        Intent intent8 = new Intent(Homescreen.this, Profile.class);
        startActivity(intent8);
    }



    public void qna(View view) {
        Intent intent10 = new Intent(Homescreen.this, Menulainnya.class);
        startActivity(intent10);
    }
}
