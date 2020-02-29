package com.mohann.stationrecyclerview

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohann.stationrecyclerview.model.FuelStation
import com.mohann.stationrecyclerview.module.station.StationAdapter
import com.mohann.stationrecyclerview.module.station.StationViewModel
import com.mohann.stationrecyclerview.utils.ApiResponseHandler
import com.mohann.stationrecyclerview.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class StationActivity : AppCompatActivity() {

    private lateinit var stationViewModel: StationViewModel
    private lateinit var stationAdapter: StationAdapter


    private lateinit var fuelStationList: ArrayList<FuelStation>
    private lateinit var filteredFuelStationList: ArrayList<FuelStation>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stationViewModel = ViewModelProvider(this).get(StationViewModel::class.java)

        val linearLayoutManager = LinearLayoutManager(this)
        rvStation.layoutManager = linearLayoutManager
        rvStation.visibility = View.GONE
        ivProgressBar.visibility = View.VISIBLE


        stationAdapter = StationAdapter()
        stationViewModel.fetchStationsList()


        rvStation.adapter = stationAdapter


        stationViewModel.fuelStationList.observe(
            this,
            Observer<ApiResponseHandler<List<FuelStation>>> { mFuelStationList ->
                if (mFuelStationList != null) {
                    when (mFuelStationList.status) {
                        ApiResponseHandler.Status.SUCCESS -> {
                            ivProgressBar.visibility = View.GONE
                            mFuelStationList.data?.let {
                                fuelStationList = it as ArrayList<FuelStation>
                                stationAdapter.updateStationListList(it)
                                rvStation.visibility = View.VISIBLE
                                llSearch.visibility = View.VISIBLE
                            }
                        }
                        ApiResponseHandler.Status.ERROR -> {
                            showToast(
                                this,
                                mFuelStationList.exception.toString()
                            )
                        }
                        else -> {
                            showToast(
                                this,
                                "Configuration Error"
                            )
                        }
                    }
                }

            })



        searchFuelStation.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                if (p1 == EditorInfo.IME_ACTION_SEARCH) {
                    hideKeyboard()
                    return true;
                }
                return false
            }

        })

        searchFuelStation.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (searchFuelStation.length() > 0) {
                    closeSearch.visibility = View.VISIBLE
                } else {
                    closeSearch.visibility = View.GONE
                }
                filter(s.toString())
            }

        })

        closeSearch.setOnClickListener {
            hideKeyboard()
            searchFuelStation.setText("")
            searchFuelStation.isFocusable = false
            searchFuelStation.isFocusableInTouchMode = true
            stationAdapter.notifyDataSetChanged()
        }

    }


    private fun filter(text: String) {
        filteredFuelStationList = ArrayList()
        for (i in fuelStationList.indices) {
            if (fuelStationList[i].stationName.toLowerCase(Locale.US).contains(
                    text.toLowerCase(
                        Locale.US
                    )
                )
            ) {
                filteredFuelStationList.add(fuelStationList[i])
            }
        }
        stationAdapter.filterStationList(filteredFuelStationList)
        if (filteredFuelStationList.size > 0) {
            tvNoResultsFound?.visibility = View.GONE
        } else {
            tvNoResultsFound?.visibility = View.VISIBLE
        }
    }

    //For hide keyboard
    private fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val inputManager =
                this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}
