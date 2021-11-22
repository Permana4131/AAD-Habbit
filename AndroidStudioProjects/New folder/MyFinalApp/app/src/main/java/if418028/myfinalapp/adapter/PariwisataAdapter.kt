package if418028.myfinalapp.adapter

import android.app.Dialog
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import if418028.myfinalapp.R
import if418028.myfinalapp.model.Pariwisata
import kotlinx.android.synthetic.main.detail_pariwisata.*
import kotlinx.android.synthetic.main.fragment_pariwisata.view.*
import kotlinx.android.synthetic.main.list_wisata.view.*

class PariwisataAdapter(var data: ArrayList<Pariwisata>?) :RecyclerView.Adapter<PariwisataAdapter.PariwisataHolder>(){
    class PariwisataHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nama = itemView.nama
        val gambar = itemView.img
        val lokasi = itemView.lokasi
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PariwisataHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_wisata, parent, false)
        val holder = PariwisataHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: PariwisataAdapter.PariwisataHolder, position: Int) {
        holder.nama.text = data?.get(position)?.nama
        holder.lokasi.text = data?.get(position)?.sumber

        Glide.with(holder.itemView.context)
            .load("http://192.168.56.1:/WebServices/final_task_mentoring/public/img/"+data?.get(position)?.gambar)
            .into(holder.gambar)

        holder.itemView.setOnClickListener{
            Dialog(holder.itemView.context).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.detail_pariwisata)
                val window = getWindow()
                val wlp = window?.attributes
                wlp?.gravity = Gravity.CENTER
                wlp?.flags = WindowManager.LayoutParams.FLAG_BLUR_BEHIND
                window?.attributes = wlp
                getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)

                Glide.with(holder.itemView.context)
                    .load("http://192.168.56.1:/WebServices/final_task_mentoring/public/img/"+data?.get(position)?.gambar)
                    .into(image)

                textNama.text = data?.get(position)?.nama
                textDetail.text = data?.get(position)?.detail
                textKategori.text = "Kategori : "+data?.get(position)?.kategori
                textSumber.text = "Sumber : "+ data?.get(position)?.sumber
                textLokasi.text ="Lokasi : "+ data?.get(position)?.lokasi
                close.setOnClickListener {
                    this.dismiss()
                }
                close2.setOnClickListener {
                    this.dismiss()
                }
            }.show()
        }
    }


}