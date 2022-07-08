package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menulainnya extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lainnya);
    }

    public void qna2(View view) {
        Intent intent = new Intent(Menulainnya.this, Menufaq.class);
        startActivity(intent);
    }

    public void about(View view) {
        Intent intent2 = new Intent(Menulainnya.this, Menutentangapk.class);
        startActivity(intent2);
    }

    public void back2(View view) {
        Intent intent3 = new Intent(Menulainnya.this, Homescreen.class);
        startActivity(intent3);
    }
}
