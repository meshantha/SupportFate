package com.kalum.wheel.data.remote

import com.kalum.wheel.data.remote.response.UserListResponse
import com.kalum.wheel.domain.model.User
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Kalum Fernando on 11/2/2018.
 */

interface UserApi {
    @GET("api/engineers")
    fun fetchUsers(): Observable<UserListResponse<User>>

}