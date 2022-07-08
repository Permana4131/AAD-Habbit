 package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

     public void home(View view) {
         Intent intent = new Intent(Profile.this, Homescreen.class);
         startActivity(intent);
     }

     public void logout(View view) {
        Intent intent2 = new Intent(Profile.this, Login.class);
        startActivity(intent2);
     }

     public void chat(View view) {
         Intent intent5 = new Intent(Profile.this, Chat.class);
         startActivity(intent5);
     }

     public void keranjang(View view) {
         Intent intent9 = new Intent(Profile.this, Keranjang.class);
         startActivity(intent9);
     }

     public void qna(View view) {
         Intent intent10 = new Intent(Profile.this, Menufaq.class);
         startActivity(intent10);
     }
 }