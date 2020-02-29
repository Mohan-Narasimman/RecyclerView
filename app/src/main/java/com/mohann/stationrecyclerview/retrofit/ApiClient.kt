package com.mohann.stationrecyclerview.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASEURL = "https://developer.nrel.gov/api/alt-fuel-stations/"
    private lateinit var retrofit: Retrofit
    val client: Retrofit
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            retrofit = Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
}