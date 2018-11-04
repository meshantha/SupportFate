package com.kalum.wheel.repository

import com.kalum.wheel.data.remote.UserApi
import com.kalum.wheel.domain.repository.ScheduleRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class ScheduleRepositoryTest {

    @Mock
    private lateinit var api: UserApi

    @InjectMocks
    private lateinit var scheduleRepository: ScheduleRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        // init api objects here
    }

    @Test
    fun getSchedulesWithSuccess() {
        scheduleRepository.getSchedules()
        verify<UserApi>(api).fetchUsers()
    }

}