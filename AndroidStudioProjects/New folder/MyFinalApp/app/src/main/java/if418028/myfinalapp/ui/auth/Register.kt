package if418028.myfinalapp.ui.auth

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import if418028.myfinalapp.R
import if418028.myfinalapp.model.ResponseServe
import if418028.myfinalapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.progress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        progress.visibility = View.INVISIBLE

        haveAcc.setOnClickListener(){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

        val  teEmail = tEmail.text
        val teName  = tName.text
        val tePassword = tPassword.text
        val teCPassword = tCPassword.text
        val teNohp = tnohp.text

        registerBtn.setOnClickListener(){
            progress.visibility = View.VISIBLE
            if (!tePassword.toString().equals(teCPassword.toString())){
                progress.visibility = View.GONE
                Toast.makeText(getApplicationContext(), "Password Tidak Sama", Toast.LENGTH_LONG).show()
            }else if(!mailCek(tEmail.toString())){
                progress.visibility = View.GONE
                Toast.makeText(getApplicationContext(), "Format email salah", Toast.LENGTH_LONG).show()
            }else if (teName.isEmpty() || teNohp.isEmpty() || teCPassword.isEmpty()){
                progress.visibility = View.GONE
                Toast.makeText(getApplicationContext(), "Ada from yang kosong", Toast.LENGTH_LONG).show()
            }else{
                progress.visibility = View.GONE
                register(teEmail.toString(), teName.toString(), tePassword.toString(), teCPassword.toString(), teNohp.toString())
            }
        }
    }

    fun register(email:String, name: String, password:String, c_password:String, nohp:String){
        if (isConnect()){
            ConfigNetwork.getRetrofi().register(email, name, password, c_password, nohp).enqueue(object : Callback<ResponseServe>{
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
                        Log.d("response server", response.message())
                        if(response.body()?.massage.equals("terdaftar")){
                            Toast.makeText(getApplicationContext(), "Email telah terdaftar", Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(getApplicationContext(), "Sukses mendaftar silahkan login", Toast.LENGTH_LONG).show()
                            val intent = Intent(this@Register, Login::class.java)
                            startActivity(intent)
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