package com.mohann.stationrecyclerview.module.station

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohann.stationrecyclerview.model.FuelStation
import com.mohann.stationrecyclerview.model.StationResponse
import com.mohann.stationrecyclerview.utils.ApiResponseHandler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class StationViewModel : ViewModel(){

    var fuelStationList = MutableLiveData<ApiResponseHandler<List<FuelStation>>>()

    var stationRepository =  StationRepository()

    fun fetchStationsList() {
        stationRepository.getStationList().enqueue(object : Callback<StationResponse> {
            override fun onFailure(call: Call<StationResponse>?, t: Throwable?) {
                fuelStationList.value = ApiResponseHandler.error(t)
            }

            override fun onResponse(call: Call<StationResponse>?, response: Response<StationResponse>?) {
                fuelStationList.value = ApiResponseHandler.success(response?.body()?.fuelStations)
            }

        })
    }


}