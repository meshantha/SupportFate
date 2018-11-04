package com.kalum.wheel

import com.kalum.wheel.repository.ScheduleRepositoryTest
import com.kalum.wheel.repository.UserRepositoryTest
import com.kalum.wheel.viewmodel.SchedulesViewModelTest
import com.kalum.wheel.viewmodel.UsersViewModelTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses


@RunWith(Suite::class)
@SuiteClasses(*[
    (ScheduleRepositoryTest::class),
    (UserRepositoryTest::class),
    (SchedulesViewModelTest::class),
    (UsersViewModelTest::class)
])
class TestSuite