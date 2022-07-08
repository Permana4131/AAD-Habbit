package com.example.fishkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fishkuy.data.model.UserResponse;
import com.example.fishkuy.data.network.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText edtName, edtEmail, edtNoHp, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edt_nama);
        edtEmail = findViewById(R.id.edt_email);
        edtNoHp = findViewById(R.id.edt_no_hp);
        edtPassword = findViewById(R.id.edt_password);
    }

    public void back15(View view) {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }

    public void next4(View view) {
        Intent intent2 = new Intent(Register.this, Register2.class);
        startActivity(intent2);
    }

    public void login(){

        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String noHp = edtNoHp.getText().toString();
        String password = edtPassword.getText().toString();

        new ApiResponse().apiInstance().register(name, email, noHp, password)
                .enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.body().getSuccess()!=1){
                            error(response.body().getMessage());
                        }else {
                            Intent intent3 = new Intent(Register.this, Register3.class);
                            startActivity(intent3);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        error(t.getMessage());
                    }
                });
    }

    public void error(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
//        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
//                .setTitleText("Oops...")
//                .setContentText(pesan)
//                .show();
    }
}