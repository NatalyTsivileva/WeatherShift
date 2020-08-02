package ru.civilea.weathershift.model

import android.content.Context
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.civilea.core.R

@Parcelize
data class Weather(
    var id:Long=0,
    var degree:Long=0
) : Parcelable