package com.kalum.wheel.di.modules

import com.kalum.wheel.data.local.AppDatabase
import com.kalum.wheel.data.local.UserDao
import com.kalum.wheel.data.remote.UserApi
import com.kalum.wheel.domain.repository.ScheduleRepository
import com.kalum.wheel.domain.repository.UserRepository
import com.kalum.wheel.util.schedulers.BaseScheduler
import com.kalum.wheel.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * * Created by Kalum Fernando on 11/2/2018.
 */

@Module(includes = [(ViewModelModule::class),(RoomModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideApi(retorfit: Retrofit): UserApi {
        return retorfit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi): UserRepository {
        return UserRepository(api)
    }

    @Provides
    @Singleton
    fun provideScheduleRepository(appDatabase: AppDatabase): ScheduleRepository {
        return ScheduleRepository(appDatabase.userDao())
    }

    @Provides
    @Singleton
    fun provideScheduler(): BaseScheduler {
        return SchedulerProvider()
    }

    @Singleton
    @Provides
    fun provideUserDao(app : AppDatabase): UserDao {
        return app.userDao()
    }

}