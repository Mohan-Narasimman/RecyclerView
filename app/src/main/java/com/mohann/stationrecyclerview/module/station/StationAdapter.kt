package com.mohann.stationrecyclerview.module.station

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mohann.stationrecyclerview.R
import com.mohann.stationrecyclerview.databinding.ItemListBinding
import com.mohann.stationrecyclerview.model.FuelStation

class StationAdapter() :
    RecyclerView.Adapter<StationAdapter.StationViewHolder>() {

    private lateinit var fuelStationList: List<FuelStation>
    private lateinit var binding: ItemListBinding

    fun updateStationListList(fuelStationList: List<FuelStation>) {
        this.fuelStationList = fuelStationList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StationViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list, parent, false
        )
        return StationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fuelStationList.size
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        val fuelStation: FuelStation = fuelStationList[position]
        holder.setIsRecyclable(false)
        binding.station = fuelStation
    }

    inner class StationViewHolder(binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    fun filterStationList(filterList: List<FuelStation>) {
        fuelStationList = filterList
        notifyDataSetChanged()
    }
}