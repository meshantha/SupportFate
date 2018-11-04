package com.kalum.wheel.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.kalum.wheel.data.remote.response.Response
import com.kalum.wheel.data.remote.response.UserListResponse
import com.kalum.wheel.domain.model.Schedule
import com.kalum.wheel.domain.repository.ScheduleRepository
import com.kalum.wheel.mock.Mocks.createSchedules
import com.kalum.wheel.ui.schedules.ScheduleViewModel
import com.kalum.wheel.util.TestSchedulerProvider
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class SchedulesViewModelTest {

    @Rule
    @JvmField
    val instantExecutor = InstantTaskExecutorRule()

    private lateinit var scheduleRepository: ScheduleRepository

    private lateinit var listScheduleViewModel: ScheduleViewModel

    @Before
    fun setUp() {
        scheduleRepository = mock<ScheduleRepository>(ScheduleRepository::class.java)
        listScheduleViewModel = ScheduleViewModel(
                TestSchedulerProvider(TestScheduler()),
                scheduleRepository
        )
//        `when`(scheduleRepository.getSchedules()).thenReturn(just(UserListResponse(
//                0,
//                0,
//                createSchedules()
//        )))
    }

    @Test
    fun empty() {
        val result = mock(Observer::class.java)
        listScheduleViewModel.response.observeForever(result as Observer<Response<List<Schedule>>>)
        verifyNoMoreInteractions(scheduleRepository)
    }

    @Test
    fun loadScedulesWithSuccess() {
        val result = mock(Observer::class.java)
        listScheduleViewModel.response.observeForever(result as Observer<Response<List<Schedule>>>)
        listScheduleViewModel.loadData()
        verify<ScheduleRepository>(scheduleRepository).getSchedules()
    }

}