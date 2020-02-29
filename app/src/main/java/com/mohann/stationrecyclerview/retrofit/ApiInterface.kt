package com.mohann.stationrecyclerview.retrofit

import com.mohann.stationrecyclerview.model.StationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v1.json")
    fun getStations(
        @Query("api_key") key: String,
        @Query("fuel_type") language: String,
        @Query("state") state: String,
        @Query("limit") limit: Int
    ): Call<StationResponse>

}