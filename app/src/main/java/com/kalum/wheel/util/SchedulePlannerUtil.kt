package com.kalum.wheel.util

import com.kalum.wheel.domain.model.Schedule
import com.kalum.wheel.domain.model.User
import com.kalum.wheel.util.Constants.USER_OFF_DAYS
import com.kalum.wheel.util.Constants.MAX_SHIFTS_PER_DAY
import com.kalum.wheel.util.Constants.MAX_SHIFTS_PER_USER
import com.kalum.wheel.util.Constants.SCHEDULE_PERIOD_DAYS
import java.util.*

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

class SchedulePlannerUtil(users: List<User>) {

    var users: MutableList<User>? = null
    var tempUsers: HashMap<String, User> = LinkedHashMap<String, User>()
    var shifts: HashMap<Int, MutableList<User>> = LinkedHashMap<Int, MutableList<User>>()
    var userOff: MutableList<User> = ArrayList<User>()
    var removedUsers: MutableList<String> = ArrayList()
    val totalShits = LinkedHashMap<String, Int>()


    private var takenShits: Int = 0


    init {
        this.users = users.toMutableList()
        for (engineer in users) {
            tempUsers[engineer.id] = engineer
            totalShits[engineer.id] = 0
        }
        shifts[0] = ArrayList(users)
    }

    val schedules: List<Schedule>?
        get() {
            val schedules = ArrayList<Schedule>()
            for (i in 0 until SCHEDULE_PERIOD_DAYS) {
                val schedule = generateShifts(i)
                schedules.add(schedule)
            }
            if (removedUsers.size != tempUsers.size) {
                return null
            }
            return schedules
        }

    private fun getRandomUser(): User {
        val possibleUsers = ArrayList<User>()
        val totalShifts = SCHEDULE_PERIOD_DAYS * MAX_SHIFTS_PER_DAY
        if (takenShits >= totalShifts / MAX_SHIFTS_PER_DAY * USER_OFF_DAYS) {
            for (i in 0 until MAX_SHIFTS_PER_DAY) {
                if (possibleUsers.size == 0) {
                    val users = shifts[i]
                    if (users != null && users.size > 0) {
                        possibleUsers.addAll(users)
                    }
                    possibleUsers.removeAll(userOff)
                }
            }
        }
        if (possibleUsers.size == 0) {
            possibleUsers.addAll(users!!)
        }
        val randomIndex = getRandomNumber(possibleUsers.size)
        return possibleUsers[randomIndex]

    }


    private fun generateShifts(currentDay: Int): Schedule {
        val shiftEngineers = ArrayList<User>()

        for (j in 0 until MAX_SHIFTS_PER_DAY) {
            val pickedUser = getRandomUser()
            val userTotalShifts: Int = totalShits.getValue(pickedUser.id)
            var usersWithShifts: MutableList<User>? = shifts.get(userTotalShifts)

            if (usersWithShifts != null) {
                usersWithShifts.remove(pickedUser)
                shifts[userTotalShifts] = usersWithShifts
            }

            val userNewTotalShifts = userTotalShifts.plus(1)
            totalShits[pickedUser.id] = userNewTotalShifts

            usersWithShifts = shifts[userNewTotalShifts]
            if (usersWithShifts == null) {
                usersWithShifts = ArrayList<User>()
            }

            usersWithShifts.add(pickedUser)
            shifts[userNewTotalShifts] = usersWithShifts


            shiftEngineers.add(pickedUser)
            takenShits.inc()

            this.users!!.remove(pickedUser)

            userOff.add(pickedUser)

            userCompletedMaxShifts(pickedUser)

            usersOff(currentDay, j)
        }

        return Schedule(currentDay, currentDay.toString(), shiftEngineers)
    }

    private fun usersOff(currentDay: Int, currentShift: Int) {
        if (currentDay > USER_OFF_DAYS && currentShift == MAX_SHIFTS_PER_DAY - 1 || userOff.size == MAX_SHIFTS_PER_DAY * (USER_OFF_DAYS + 1)) {
            for (j in 0 until MAX_SHIFTS_PER_DAY) {
                if (userOff.size > 0) {
                    val engineer = userOff[0]
                    if (!users!!.contains(engineer) && !removedUsers.contains(engineer.id)) {
                        users!!.add(engineer)
                    }

                    userOff.removeAt(0)
                }
            }
        }
    }

    private fun userCompletedMaxShifts(engineer: User) {
        val engTotalShifts = totalShits[engineer.id]
        if (engTotalShifts == MAX_SHIFTS_PER_USER) {
            removedUsers.add(engineer.id)
        }
    }

    private fun getRandomNumber(max: Int): Int {
        if (max > 0) {
            val ran = Random()
            return ran.nextInt(max)
        } else {
            return 0
        }
    }


}