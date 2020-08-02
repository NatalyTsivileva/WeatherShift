package ru.civilea.weathershift.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    var id:Long=0,
    var name:String="",
    var weather:Weather=Weather()
) : Parcelable