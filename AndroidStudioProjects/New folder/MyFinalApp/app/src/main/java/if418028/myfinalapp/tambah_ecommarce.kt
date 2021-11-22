package if418028.myfinalapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import if418028.myfinalapp.model.ResponseServe
import if418028.myfinalapp.network.ConfigNetwork
import if418028.myfinalapp.ui.auth.Login
import kotlinx.android.synthetic.main.activity_tambah_ecommarce.*
import kotlinx.android.synthetic.main.list_eccomarce.*

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class tambah_ecommarce : AppCompatActivity() {
    private var bitmap: Bitmap? = null
    var mFoto: ImageView? = null

    private lateinit var preferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_ecommarce)

        mFoto = findViewById<ImageView>(R.id.pFoto)

        preferences = this.getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE)
        val nama = tNama.text
        val harga = tHarga.text
        val kategori = tKategorie.text
        val keterangan = tDetail.text
        val lokasi = tLokasi.text
        val penjual =  preferences.getString(Login.tag_id, null)

        pFoto.setOnClickListener(){
            addImg()
        }

        tambahBtn.setOnClickListener(){
            addData(nama.toString(), penjual.toString(), harga.toString(), keterangan.toString(), kategori.toString(), lokasi.toString())
            }

    }

    fun addImg(){
        val intent = Intent()
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            val filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath)
                mFoto?.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }

    fun createTempFile(bitmap: Bitmap):File{
        var file  = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),
            System.currentTimeMillis().toString()+"_image.PNG")
        var bos = ByteArrayOutputStream()

        bitmap.compress(Bitmap.CompressFormat.PNG,0, bos)
        var bitmapData = bos.toByteArray()

        try {
            var fos =  FileOutputStream(file)
            fos.write(bitmapData)
            fos.flush()
            fos.close()
        } catch (e:IOException) {
            e.printStackTrace()
        }
        return file;

        println(file.toString())
    }

    fun addData(nama: String, penjual: String, harga : String, detail : String, kategori : String, lokasi: String){
        val map = HashMap<String, RequestBody>()
        map.put("nama", createFormatString(nama))
        map.put("penjual", createFormatString(penjual))
        map.put("harga", createFormatString(harga))
        map.put("detail", createFormatString(detail))
        map.put("kategori", createFormatString(kategori))
        map.put("lokasi", createFormatString(lokasi))

        var file: File? = null
        var body: MultipartBody.Part? = null
        if (bitmap == null) {
            file = null
            body = null
        } else {
            file = createTempFile(bitmap!!)
            val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
            body = MultipartBody.Part.createFormData("gambar", file.name, reqFile)
        }

        ConfigNetwork.getRetrofi().addEcommarce(body, map).enqueue(object : Callback<ResponseServe>{
            override fun onFailure(call: Call<ResponseServe>, t: Throwable) {
                t.message?.let { Log.d("error Server", it) }
            }

            override fun onResponse(call: Call<ResponseServe>, response: Response<ResponseServe>) {
                if (response.isSuccessful){
                    Toast.makeText(getApplicationContext(), response.body()?.massage, Toast.LENGTH_LONG).show()
                    if (response.body()?.status.equals("ok")){
                        val intent = Intent(this@tambah_ecommarce, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(getApplicationContext(), response.body()?.massage, Toast.LENGTH_LONG).show()
                    }
                }
            }

        })


    }

    @NonNull
    fun createFormatString(descriptionString:String):RequestBody  {
        return RequestBody.create(
            MultipartBody.FORM, descriptionString);
    }
}