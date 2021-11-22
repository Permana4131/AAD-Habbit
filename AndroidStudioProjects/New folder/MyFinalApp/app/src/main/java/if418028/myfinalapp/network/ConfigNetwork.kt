package if418028.myfinalapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {
    companion object{
        fun getRetrofi():myAppServices{
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val services = retrofit.create(myAppServices::class.java)

            return services
        }
    }
}