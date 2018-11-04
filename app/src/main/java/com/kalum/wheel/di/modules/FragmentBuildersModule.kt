package com.kalum.wheel.di.modules

import com.kalum.wheel.ui.schedules.SchedulesFragment
import com.kalum.wheel.ui.users.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface FragmentBuildersModule {

    @ContributesAndroidInjector
    fun contributeUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun contributeSchedulesFragment(): SchedulesFragment

}