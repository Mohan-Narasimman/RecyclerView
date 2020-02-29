package com.mohann.stationrecyclerview.utils

import android.content.Context
import android.widget.Toast



fun showToast(applicationContext: Context, message: String) {
    val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
    toast.show()
}