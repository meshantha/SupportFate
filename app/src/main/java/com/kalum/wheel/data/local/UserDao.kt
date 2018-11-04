package com.kalum.wheel.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.kalum.wheel.domain.model.User
import io.reactivex.Flowable


/**
 * Created by Kalum Fernando on 11/3/2018.
 */

@Dao
interface UserDao {
    @get:Query("SELECT * FROM users")
    val all: Flowable<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Query("DELETE FROM users")
    fun deleteAll()
}