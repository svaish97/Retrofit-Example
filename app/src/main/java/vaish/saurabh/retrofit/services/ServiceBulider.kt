package vaish.saurabh.retrofit.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBulider {
    private const val URL="https://api.github.com"

    private val okHttpClient=OkHttpClient.Builder()
    private val builder=Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())
    private val retrofit= builder.build()
    fun buildService():GetUsers{
        return retrofit.create(GetUsers::class.java)
    }
}