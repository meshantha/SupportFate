package com.kalum.wheel.ui.schedules

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kalum.wheel.R
import com.kalum.wheel.domain.model.Schedule

import com.kalum.wheel.ui.base.BaseAdapter

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

class ScheduleAdapter constructor(list: List<Schedule>) : BaseAdapter<Schedule>(list) {
    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder?, position: Int) {
        val binding = (holder as ScheduleViewHolder).binding
        val my = list[position]
        binding?.schedule = my
    }

    override fun onCreateViewHolderBase(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ScheduleViewHolder(LayoutInflater
                .from(parent?.context)
                .inflate(R.layout.schedule_item, parent, false))
    }


}