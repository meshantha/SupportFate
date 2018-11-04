package com.kalum.wheel.domain.repository

import com.kalum.wheel.data.local.AppDatabase
import com.kalum.wheel.data.local.UserDao
import com.kalum.wheel.data.local.UserDao_Impl
import com.kalum.wheel.data.remote.UserApi
import com.kalum.wheel.data.remote.response.UserListResponse
import com.kalum.wheel.domain.model.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

class UserRepository @Inject constructor(private val api: UserApi) {

    fun getUsers(): Observable<UserListResponse<User>> {
        return api.fetchUsers()
    }

}