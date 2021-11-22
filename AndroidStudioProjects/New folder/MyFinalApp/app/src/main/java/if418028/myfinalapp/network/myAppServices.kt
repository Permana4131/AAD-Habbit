package if418028.myfinalapp.network

import if418028.myfinalapp.model.ResponseServe
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface myAppServices {

    @GET("pariwisata")
    fun getDataPariwisata(): Call<ResponseServe>

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email :String,
              @Field("password") password :String) : Call<ResponseServe>

    @FormUrlEncoded
    @POST("register")
    fun register(@Field("email") email :String,
                 @Field("name") name :String,
                 @Field("password") password: String,
                 @Field("c_password") c_password:String,
                 @Field("nohp") nohp:String) : Call<ResponseServe>


    @FormUrlEncoded
    @POST("password/create")
    fun lupaPassowrd(@Field("email")email :String) : Call<ResponseServe>

    @FormUrlEncoded
    @POST("password/reset")
    fun resetPassword(@Field("email") email: String,
                      @Field("token") token:String,
                      @Field("password")password: String) : Call<ResponseServe>

    @GET("ecommarce")
    fun getEcommarce(): Call<ResponseServe>

    @Multipart
    @POST("ecommarce/add")
    fun addEcommarce(@Part gambar : MultipartBody.Part?,
                        @PartMap  text :Map<String, @JvmSuppressWildcards RequestBody>) : Call<ResponseServe>

    @GET("ecommarce/penjual/{penjual}")
    fun getEcommarcePenjual(@Path("penjual") penjual:String): Call<ResponseServe>

    @GET("ecommarce/delete/{id}")
    fun deleteEcommarce(@Path("id") id:String?): Call<ResponseServe>
}