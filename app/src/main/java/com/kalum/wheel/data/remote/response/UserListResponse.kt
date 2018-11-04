package com.kalum.wheel.data.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Kalum Fernando on 11/2/2018.
 */

data class UserListResponse<out T>(
        @SerializedName("engineers") val data: List<T>
)