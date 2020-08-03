package ru.civilea.common.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class City(
    @SerializedName("id")
    val id: Long = 0,

    @SerializedName("name")
    val name: String = "",


    @SerializedName("weatherdegree")
    val weatherDegree: Long = 0
) : Serializable