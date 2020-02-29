package com.mohann.stationrecyclerview.module.station

import com.mohann.stationrecyclerview.model.StationResponse
import com.mohann.stationrecyclerview.retrofit.ApiClient
import com.mohann.stationrecyclerview.retrofit.ApiInterface
import retrofit2.Call

class StationRepository {

    private val API_KEY = "DEMO_KEY"

    private val FUEL_TYPE = "E85,ELEC"

    private var STATE = "CA"

    private val LIMIT = 100


    fun getStationList(): Call<StationResponse> {
        val apiInterface = ApiClient.client.create(ApiInterface::class.java)
        return apiInterface.getStations(API_KEY,FUEL_TYPE,STATE,LIMIT)
    }
}