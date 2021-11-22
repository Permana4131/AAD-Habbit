package if418028.myfinalapp.adapter

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import if418028.myfinalapp.R
import if418028.myfinalapp.model.Ecommarce
import if418028.myfinalapp.model.ResponseServe
import if418028.myfinalapp.my_ecommarce
import if418028.myfinalapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.fragment_ecommarce.view.*
import kotlinx.android.synthetic.main.list_eccomarce.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EcommarceAdapter(var data: ArrayList<Ecommarce>?) :RecyclerView.Adapter<EcommarceAdapter.EcommarceHolder>() {
    class EcommarceHolder(itemVeiw : View) : RecyclerView.ViewHolder(itemVeiw) {
        val img =  itemVeiw.list_image
        val name = itemVeiw.name
        val harga = itemVeiw.harga
        val penjual = itemVeiw.penjual
        val delete = itemVeiw.cart_delete

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EcommarceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_eccomarce, parent, false)
        val holder = EcommarceHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: EcommarceHolder, position: Int) {
        holder.name.text = data?.get(position)?.nama
        holder.harga.text = data?.get(position)?.harga.toString()
        holder.penjual.text = data?.get(position)?.penjual

        Glide.with(holder.itemView.context)
                .load("http://192.168.56.1:/WebServices/final_task_mentoring/public/img/"+data?.get(position)?.gambar)
                .into(holder.img)


        holder.delete.setOnClickListener(){
            delete(data?.get(position)?.id, holder)
        }
    }

    fun delete(id: String?, holder: EcommarceHolder){
        ConfigNetwork.getRetrofi().deleteEcommarce(id).enqueue(object : Callback<ResponseServe> {
            override fun onFailure(call: Call<ResponseServe>, t: Throwable) {
                t.message?.let { Log.d("error Server", it) }
            }

            override fun onResponse(call: Call<ResponseServe>, response: Response<ResponseServe>) {
                if (response.isSuccessful){
                    val status = response.body()?.status
                    if (status.equals("ok")){
                        val intent = Intent(holder.itemView.context, my_ecommarce::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                }
            }

        })
    }

}