package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menutentangapk extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tentangapk);
    }

    public void back3(View view) {
        Intent intent = new Intent(Menutentangapk.this, Menulainnya.class);
        startActivity(intent);
    }
}
