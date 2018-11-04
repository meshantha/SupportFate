package com.kalum.wheel.domain.repository

import com.kalum.wheel.data.local.UserDao
import com.kalum.wheel.domain.model.User
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Kalum Fernando on 11/2/2018.
 */

class ScheduleRepository @Inject constructor(private val userDao: UserDao) {

    fun getSchedules(): Single<List<User>> {
        return userDao.all.onBackpressureBuffer().firstOrError()
    }

}