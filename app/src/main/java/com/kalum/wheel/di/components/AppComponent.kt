package com.kalum.wheel.di.components

import com.kalum.wheel.App
import com.kalum.wheel.di.modules.ActivityBuildersModule
import com.kalum.wheel.di.modules.AppModule
import com.kalum.wheel.di.modules.NetworkModule
import com.kalum.wheel.di.modules.RoomModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuildersModule::class,
    AppModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()


}