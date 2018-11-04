package com.kalum.wheel.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

data class Schedule(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        val engineers: List<User>
)