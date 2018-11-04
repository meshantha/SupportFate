package com.kalum.wheel.repository

import com.kalum.wheel.data.remote.UserApi
import com.kalum.wheel.domain.repository.UserRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class UserRepositoryTest {

    @Mock
    private lateinit var api: UserApi

    @InjectMocks
    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
// implement here the api mock
    }

    @Test
    fun getUsersWithSuccess() {
        userRepository.getUsers()
        verify<UserApi>(api).fetchUsers()
    }

}