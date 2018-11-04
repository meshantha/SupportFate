package com.kalum.wheel.mock

import com.kalum.wheel.domain.model.Schedule
import com.kalum.wheel.domain.model.User
import java.util.*

object Mocks {

    fun createUsers(): List<User> {
        val users = ArrayList<User>()

        users.add(User(1, "1", "Kalum"))
        users.add(User(2, "2", "Nimal"))
        users.add(User(3, "3", "Saman"))
        users.add(User(4, "4", "Tom"))
        users.add(User(5, "5", "Aron"))
        users.add(User(6, "6", "Saman"))
        users.add(User(7, "7", "Diyanne"))
        users.add(User(8, "8", "Kaely"))
        users.add(User(9, "9", "Imansa"))
        users.add(User(10, "10", "Dinali"))


        return users
    }

    fun createSchedules(): List<Schedule> {
        val schedules = ArrayList<Schedule>()

        schedules.add(Schedule(1, "Day 1", listOf()))
        schedules.add(Schedule(2, "Day 2", listOf()))
        schedules.add(Schedule(3, "Day 3", listOf()))

        return schedules
    }

}