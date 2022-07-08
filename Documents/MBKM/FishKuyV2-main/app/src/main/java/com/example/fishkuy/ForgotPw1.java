package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgotPw1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw1);
    }

    public void back17(View view) {
        Intent intent = new Intent(ForgotPw1.this, Login.class);
        startActivity(intent);
    }

    public void next6(View view) {
        Intent intent2 =new Intent(ForgotPw1.this, ForgotPw2.class);
        startActivity(intent2);
    }

    public void login2(View view) {
        Intent intent3 = new Intent(ForgotPw1.this, Login.class);
        startActivity(intent3);
    }
}