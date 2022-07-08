package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menufaq extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_faq);
    }

    public void back4(View view) {
        Intent intent = new Intent(Menufaq.this, Menulainnya.class);
        startActivity(intent);
    }
}
