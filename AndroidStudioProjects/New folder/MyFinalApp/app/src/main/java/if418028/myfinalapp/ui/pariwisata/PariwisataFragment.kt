package if418028.myfinalapp.ui.pariwisata

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import if418028.myfinalapp.R
import if418028.myfinalapp.adapter.PariwisataAdapter
import if418028.myfinalapp.model.Pariwisata
import if418028.myfinalapp.model.ResponseServe
import if418028.myfinalapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.fragment_pariwisata.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PariwisataFragment : Fragment() {

    private lateinit var homeViewModel: PariwisataViewModel
    var dataPariwisata:ArrayList<Pariwisata>? = ArrayList()
    var displayList:ArrayList<Pariwisata>? = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(PariwisataViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pariwisata, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        val progress = root.findViewById<ProgressBar>(R.id.progress)

        if (isConnect()){
            ConfigNetwork.getRetrofi().getDataPariwisata().enqueue(object : Callback<ResponseServe>{
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
                        progress.visibility = View.GONE
                        val status = response.body()?.success
                        if (status.equals("true")){
                            dataPariwisata = response.body()?.data
                            dataPariwisata?.let { displayList?.addAll(it) }

                            showData(displayList)
                            var kat = getKategori(dataPariwisata).distinct()
                            val adapter = ArrayAdapter<String>(root.context, android.R.layout.simple_spinner_dropdown_item, kat)
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            val kategori = root.findViewById<Spinner>(R.id.kategori)
                            kategori.adapter = adapter

                            kategori.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                                override fun onNothingSelected(p0: AdapterView<*>?) {

                                }

                                override fun onItemSelected(
                                    p0: AdapterView<*>?,
                                    p1: View?,
                                    p2: Int,
                                    p3: Long
                                ) {
                                    val ka = kategori.selectedItem.toString()
                                    println(ka)
                                    if (ka.equals("All")){
                                        displayList?.clear()
                                        dataPariwisata?.let { displayList?.addAll(it) }
                                        listPariwisata.adapter?.notifyDataSetChanged()
                                    }else{
                                        displayList?.clear()
                                        dataPariwisata?.forEach{
                                            if (it?.kategori!!.toString().contains(ka)){
                                                displayList?.add(it)
                                            }
                                        }
                                        listPariwisata.adapter?.notifyDataSetChanged()
                                    }

                                }

                            }
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

    fun getKategori(a: ArrayList<Pariwisata>?): Array<String>{

        val size = a?.size as Int
        val array = Array<String>(size+1){"null"}
        var i = 0
        array.set(i, "All")
        i++
        for (arrA in a!!){
            array.set(i, arrA.kategori.toString())
            i++
        }
        return array
    }

    private fun showData(data: ArrayList<Pariwisata>?) {
        listPariwisata.adapter = PariwisataAdapter(data)
    }
}