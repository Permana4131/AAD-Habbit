package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Register2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
    }

    public void back16(View view) {
        Intent intent = new Intent(Register2.this, Register.class);
        startActivity(intent);
    }

    public void next5(View view) {
        Intent intent2 = new Intent(Register2.this, Register3.class);
        startActivity(intent2);
    }
}