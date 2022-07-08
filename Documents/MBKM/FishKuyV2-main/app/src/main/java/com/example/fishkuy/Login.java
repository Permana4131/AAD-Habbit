package com.example.fishkuy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fishkuy.data.model.UserResponse;
import com.example.fishkuy.data.network.ApiResponse;

import me.ibrahimsn.lib.CirclesLoadingView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    CirclesLoadingView circlesLoadingView;
    EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        circlesLoadingView = findViewById(R.id.circlesLoadingView);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
    }

    public void forgotPw(View view) {
        Intent intent = new Intent(Login.this, ForgotPw1.class);
        startActivity(intent);
    }

    public void regis(View view) {
        Intent intent2 = new Intent(Login.this, Register.class);
        startActivity(intent2);
    }

    public void masuk(View view) {
        circlesLoadingView.setVisibility(View.VISIBLE);
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        new ApiResponse().apiInstance().login(email, password)
                .enqueue(new Callback<UserResponse>() {

                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.body().getSuccess()!=1){
                            error(response.body().getMessage());
                        }else{
                            Intent intent3 = new Intent(Login.this, Homescreen.class);
                            startActivity(intent3);
                            circlesLoadingView.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        error(t.getMessage());
                    }
                });
//        Handler handler = new Handler(getMainLooper());
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent3 = new Intent(Login.this, Homescreen.class);
//                startActivity(intent3);
//                circlesLoadingView.setVisibility(View.GONE);
//            }
//        }, 3000);
    }

    public void error(String pesan){
        circlesLoadingView.setVisibility(View.GONE);
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
//        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
//                .setTitleText("Oops...")
//                .setContentText(pesan)
//                .show();
    }

}