package if418028.myfinalapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import if418028.myfinalapp.adapter.EcommarceAdapter
import if418028.myfinalapp.model.Ecommarce
import if418028.myfinalapp.model.ResponseServe
import if418028.myfinalapp.network.ConfigNetwork
import if418028.myfinalapp.ui.auth.Login
import kotlinx.android.synthetic.main.activity_my_ecommarce.*
import kotlinx.android.synthetic.main.list_eccomarce.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class my_ecommarce : AppCompatActivity() {
    private lateinit var preferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_ecommarce)



        preferences = this.getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE)
        val penjual =  preferences.getString(Login.tag_id, null)
        if (isConnect()){
            ConfigNetwork.getRetrofi().getEcommarcePenjual(penjual.toString()).enqueue(object :
                Callback<ResponseServe>{
                override fun onFailure(call: Call<ResponseServe>, t: Throwable) {
                    t.message?.let { Log.d("error Server", it) }
                }

                override fun onResponse(
                    call: Call<ResponseServe>,
                    response: Response<ResponseServe>
                ) {
                    val status = response.body()?.status

                    if (status.equals("ok")){
                        val data = response.body()?.dataEcommarce
                        showData(data)
                    }
                }

            })
        }
    }

    fun isConnect():Boolean{
        val connect : ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }

    fun showData(data: ArrayList<Ecommarce>?){
        listEcommarce2.adapter = EcommarceAdapter(data)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }



}