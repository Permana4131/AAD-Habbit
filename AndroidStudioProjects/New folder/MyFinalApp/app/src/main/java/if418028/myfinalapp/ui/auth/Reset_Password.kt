package if418028.myfinalapp.ui.auth

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import if418028.myfinalapp.MainActivity
import if418028.myfinalapp.R
import if418028.myfinalapp.model.ResponseServe
import if418028.myfinalapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_reset_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class Reset_Password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        progress.visibility = View.INVISIBLE
        val email = editTextEmail.text

        cirLupaButton.setOnClickListener(){
            val cek = mailCek(email.toString())
            progress.visibility = View.VISIBLE
            if(cek && email.toString().isNotEmpty()){
                lupaPw(email.toString())
            }else{
                Toast.makeText(getApplicationContext(), "Format Email tidak sesuai / Email kosong", Toast.LENGTH_LONG).show()
                progress.visibility = View.GONE
            }

        }
    }

    fun lupaPw(email:String){
        if (isConnect()){
            ConfigNetwork.getRetrofi().lupaPassowrd(email).enqueue(object : Callback<ResponseServe>{
                override fun onFailure(call: Call<ResponseServe>, t: Throwable) {
                    t.message?.let { Log.d("error Server", it) }
                    progress.visibility = View.GONE
                }

                override fun onResponse(
                    call: Call<ResponseServe>,
                    response: Response<ResponseServe>
                ) {
                    if(response.isSuccessful){
                        println(response.body()?.massage)

                        if (response.body()?.errors.equals("tidakada")){
                            Toast.makeText(getApplicationContext(), response.body()?.massage, Toast.LENGTH_LONG).show()
                            progress.visibility = View.GONE
                        }else{
                            val intent = Intent(this@Reset_Password, Confirm_reset_password::class.java)
                            intent.putExtra("email", email)
                            startActivity(intent)
                            Toast.makeText(getApplicationContext(), response.body()?.massage, Toast.LENGTH_LONG).show()
                            progress.visibility = View.GONE
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

    fun mailCek(email: String): Boolean{
        val exp = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

}