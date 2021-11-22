package if418028.myfinalapp.ui.ecommarce

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import if418028.myfinalapp.R
import if418028.myfinalapp.adapter.EcommarceAdapter
import if418028.myfinalapp.model.Ecommarce
import if418028.myfinalapp.model.ResponseServe
import if418028.myfinalapp.my_ecommarce
import if418028.myfinalapp.network.ConfigNetwork
import if418028.myfinalapp.tambah_ecommarce
import kotlinx.android.synthetic.main.fragment_ecommarce.*
import kotlinx.android.synthetic.main.fragment_ecommarce.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EcommarceFragment : Fragment() {

    private lateinit var dashboardViewModel: EcommarceViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(EcommarceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ecommarce, container, false)
        root.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val intent = Intent(root.context, tambah_ecommarce::class.java)
            startActivity(intent)
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
        }

        root.barangku.setOnClickListener(){
            val intent = Intent(root.context, my_ecommarce::class.java)
            startActivity(intent)
        }

        if (isConnect()){
            ConfigNetwork.getRetrofi().getEcommarce().enqueue(object : Callback<ResponseServe>{
                override fun onFailure(call: Call<ResponseServe>, t: Throwable) {
                    t.message?.let { Log.d("error Server", it) }
                }

                override fun onResponse(call: Call<ResponseServe>, response: Response<ResponseServe>) {
                    if (response.isSuccessful){
                        val status = response.body()?.status
                        if (status.equals("ok")){
                            val data = response.body()?.dataEcommarce
                            showData(data)
                        }
                    }
                }

            })
        }



        return root
    }

    fun isConnect():Boolean{
        val connect : ConnectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }

    fun showData(data: ArrayList<Ecommarce>?){
        listEcommarce.adapter = EcommarceAdapter(data)
    }


}