package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Search2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_search2);
    }

    public void back19(View view) {
        Intent intent = new Intent(Search2.this, Homescreen.class);
        startActivity(intent);
    }
}
