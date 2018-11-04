package com.kalum.wheel.util

import com.kalum.wheel.util.schedulers.BaseScheduler
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

class TestSchedulerProvider(private val testScheduler: TestScheduler) : BaseScheduler {

    override fun io(): Scheduler {
        return testScheduler
    }

    override fun ui(): Scheduler {
        return testScheduler
    }

}