package com.kalum.wheel.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kalum.wheel.di.keys.ViewModelKey
import com.kalum.wheel.ui.common.ViewModelFactory
import com.kalum.wheel.ui.schedules.ScheduleViewModel
import com.kalum.wheel.ui.users.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun bindUsersViewModel(userViewModel: UserViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ScheduleViewModel::class)
    fun bindScheduleViewModel(scheduleViewModel: ScheduleViewModel) : ViewModel

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}