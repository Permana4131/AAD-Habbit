package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    public void back20(View view) {
        Intent intent = new Intent(Chat.this, Homescreen.class);
        startActivity(intent);
    }

    public void tokonft(View view) {
        Intent intent2 = new Intent(Chat.this, Chat2.class);
        startActivity(intent2);
    }
}