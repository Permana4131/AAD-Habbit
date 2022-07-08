package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgotPw2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw2);
    }

    public void back18(View view) {
        Intent intent = new Intent(ForgotPw2.this, ForgotPw1.class);
        startActivity(intent);
    }

    public void next7(View view) {
        Intent intent2 = new Intent(ForgotPw2.this, ForgotPw3.class);
        startActivity(intent2);
    }

    public void login3(View view) {
        Intent intent3 = new Intent(ForgotPw2.this, Login.class);
        startActivity(intent3);
    }
}