package if418028.myfinalapp.ui.auth

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import if418028.myfinalapp.R
import if418028.myfinalapp.model.ResponseServe
import if418028.myfinalapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_confirm_reset_password.*
import kotlinx.android.synthetic.main.activity_confirm_reset_password.progress
import kotlinx.android.synthetic.main.activity_reset_password.editTextEmail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Confirm_reset_password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_reset_password)

        progress.visibility = View.INVISIBLE
        val email = (editTextEmail as TextView)
        email.text = intent.getStringExtra("email")
        email.isEnabled = false

        val token = editToken.text
        val password = editNewPassword.text

        cirResetButton.setOnClickListener(){
            println(email.text.toString())
            progress.visibility = View.VISIBLE
            reset(email.text.toString(), token.toString(), password.toString())
        }
    }

    fun reset(email: String, token:String, password: String){
        if (isConnect()){
            ConfigNetwork.getRetrofi().resetPassword(email, token, password).enqueue(object :
                Callback<ResponseServe>{
                override fun onFailure(call: Call<ResponseServe>, t: Throwable) {
                    progress.visibility = View.GONE
                    t.message?.let { Log.d("error Server", it) }
                }

                override fun onResponse(
                    call: Call<ResponseServe>,
                    response: Response<ResponseServe>
                ) {
                    if (response.isSuccessful){
                        progress.visibility = View.GONE
                        if (response.body()?.errors.equals("kedeluarsa")){
                            Toast.makeText(getApplicationContext(), response.body()?.massage, Toast.LENGTH_LONG).show()
                        }else{
                            val intent = Intent(this@Confirm_reset_password, Login::class.java)
                            startActivity(intent)
                            finish()
                            Toast.makeText(getApplicationContext(), response.body()?.massage+"Silahan Login", Toast.LENGTH_LONG).show()
                        }
                    }
                }

            })
        }
    }

    fun isConnect():Boolean{
        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }
}