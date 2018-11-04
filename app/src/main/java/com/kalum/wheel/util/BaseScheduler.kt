package com.kalum.wheel.util.schedulers

import android.support.annotation.NonNull
import io.reactivex.Scheduler

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

interface BaseScheduler {

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler

}