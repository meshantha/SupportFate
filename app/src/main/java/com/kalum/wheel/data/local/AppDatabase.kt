package com.kalum.wheel.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.kalum.wheel.domain.model.User

/**
 * Created by Kalum Fernando on 11/4/2018.
 */

@Database(entities =  arrayOf(User::class), version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}