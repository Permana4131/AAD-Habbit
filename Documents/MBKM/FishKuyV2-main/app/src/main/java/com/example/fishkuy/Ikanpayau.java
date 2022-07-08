package com.example.fishkuy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ikanpayau extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuikan_payau);
    }

    public void back5(View view) {
        Intent intent = new Intent(Ikanpayau.this, Homescreen.class);
        startActivity(intent);
    }

    public void beli5(View view) {
        Intent intent2 = new Intent(Ikanpayau.this, Detailproduk.class);
        startActivity(intent2);
    }

    public void chat(View view) {
        Intent intent5 = new Intent(Ikanpayau.this, Chat.class);
        startActivity(intent5);
    }

    public void keranjang(View view) {
        Intent intent9 = new Intent(Ikanpayau.this, Keranjang.class);
        startActivity(intent9);
    }

    public void lacak(View view) {
        Intent intent = new Intent(Ikanpayau.this, Lacak.class);
        startActivity(intent);
    }
}
