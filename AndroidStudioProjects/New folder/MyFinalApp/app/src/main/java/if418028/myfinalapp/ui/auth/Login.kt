package if418028.myfinalapp.ui.auth

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.editTextEmail
import kotlinx.android.synthetic.main.activity_login.progress
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class Login : AppCompatActivity() {

    companion object {
        val session_status = "session_status"
        var session = false
        val my_shared_preferences = "my_shared_preferences"
        val tag_email = "email"
        val tag_name = "name"
        val tag_id = "id"
        val tag_nohp = "nohp"
        var email:String?  = null
        var name:String? = null
    }

    lateinit var sharedpreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE)
        session = sharedpreferences.getBoolean(
            session_status, false)
        name = sharedpreferences.getString(
            tag_name, null)
        email = sharedpreferences.getString(
            tag_email, null)
        progress.visibility = View.INVISIBLE
        if (session){
            val intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }
            val eEmail = editTextEmail.text
            val password = editTextPassword.text
            cirLoginButton.setOnClickListener(){
                progress.visibility = View.VISIBLE
                if(password.isEmpty() || eEmail.isEmpty()){
                    progress.visibility = View.GONE
                    Toast.makeText(getApplicationContext(), "Passwoord / email  tidak boleh kosong"+mailCek(eEmail.toString()), Toast.LENGTH_LONG).show()
                }else if(!mailCek(eEmail.toString())){
                    progress.visibility = View.GONE
                    Toast.makeText(getApplicationContext(), "Format email salah", Toast.LENGTH_LONG).show()
                }else{
                    login(eEmail.toString(), password.toString())
                }

            }

            register.setOnClickListener(){
                val intent = Intent(this, Register::class.java)
                startActivity(intent)
            }

        lpw.setOnClickListener(){
            val intent = Intent(this, Reset_Password::class.java)
            startActivity(intent)
        }




    }

    fun login(eEmail: String, password: String){
        if (isConnect()){
            ConfigNetwork.getRetrofi().login(eEmail, password).enqueue(object :
                Callback<ResponseServe> {
                override fun onFailure(call: Call<ResponseServe>, t: Throwable) {
                    progress.visibility = View.GONE
                    t.message?.let { Log.d("error Server", it) }
                }

                override fun onResponse(
                    call: Call<ResponseServe>,
                    response: Response<ResponseServe>
                ) {
                    Log.d("response server", response.message())
                    if (response.isSuccessful){
                        println(response.body()?.status)
                        progress.visibility = View.GONE
                        if (response.body()?.status.equals("success")){
                            val editor = sharedpreferences.edit()
                            editor.putBoolean(session_status, true)
                            editor.putString(tag_email, eEmail)
                            editor.putString(tag_name, response.body()?.name)
                            editor.putString(tag_id, response.body()?.id)
                            editor.commit()
                            val intent = Intent(this@Login, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            progress.visibility = View.GONE
                            Toast.makeText(getApplicationContext(), "Email / Password salah!", Toast.LENGTH_LONG).show()
                        }

                    }else{
                        progress.visibility = View.GONE
                        Toast.makeText(getApplicationContext(), "Email / Password salah!", Toast.LENGTH_LONG).show()
                    }
                }

            })
        }else{
            progress.visibility = View.GONE
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show()
        }

    }

    fun isConnect():Boolean{
        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun mailCek(email: String): Boolean{
        val exp = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,25}" +
                        ")+"
        ).matcher(email).matches()
        return exp
    }

}