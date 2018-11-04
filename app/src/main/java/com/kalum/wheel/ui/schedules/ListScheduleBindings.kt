package com.kalum.wheel.ui.schedules

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.kalum.wheel.domain.model.Schedule
import java.util.Collections.emptyList

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

object ListScheduleBindings {

    @JvmStatic
    @BindingAdapter("load_schedules")
    fun loadSchedules(recyclerView: RecyclerView, schedule: List<Schedule>?) {
        recyclerView.adapter = if (schedule != null) ScheduleAdapter(schedule) else ScheduleAdapter(emptyList())
    }


}