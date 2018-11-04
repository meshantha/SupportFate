package com.kalum.wheel.data.remote.response

/**
 * Created by Kalum Fernando on 11/2/2018.
 */

data class Response<out T> (
        val status: Int,
        val data: T?,
        val error: Throwable?
)