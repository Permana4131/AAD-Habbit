package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(getMainLooper());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Onboarding1.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    public void next(View view) {
//        Intent intent =new Intent(MainActivity.this, Onboarding1.class);
//        startActivity(intent);
    }
}