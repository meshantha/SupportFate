package com.kalum.wheel.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.kalum.wheel.data.remote.response.Response
import com.kalum.wheel.domain.model.User
import com.kalum.wheel.domain.repository.UserRepository
import com.kalum.wheel.ui.users.UserViewModel
import com.kalum.wheel.util.TestSchedulerProvider
import io.reactivex.Observable.just
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class UsersViewModelTest {

    @Rule
    @JvmField
    val instantExecutor = InstantTaskExecutorRule()

    private lateinit var userRepository: UserRepository

    private lateinit var listUsersViewModel: UserViewModel

    @Before
    fun setUp() {
        userRepository = mock<UserRepository>(UserRepository::class.java)

    }

    @Test
    fun empty() {
        val result = mock(Observer::class.java)
        listUsersViewModel.response.observeForever(result as Observer<Response<List<User>>>)
        verifyNoMoreInteractions(userRepository)
    }

    @Test
    fun loadUsersWithSuccess() {
        val result = mock(Observer::class.java)
        listUsersViewModel.response.observeForever(result as Observer<Response<List<User>>>)
        listUsersViewModel.loadData()
        verify<UserRepository>(userRepository).getUsers()
    }

}