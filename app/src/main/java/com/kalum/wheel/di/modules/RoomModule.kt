package com.kalum.wheel.di.modules

import android.arch.persistence.room.Room
import com.kalum.wheel.App
import com.kalum.wheel.data.local.AppDatabase
import com.kalum.wheel.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Kalum Fernando on 11/3/2018.
 */

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(app: App): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
    }


}