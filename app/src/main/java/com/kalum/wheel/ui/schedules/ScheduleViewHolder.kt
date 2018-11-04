package com.kalum.wheel.ui.schedules

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.kalum.wheel.databinding.ScheduleItemBinding

/**
 * Created by Kalum Fernando on 11/1/2018.
 */

class ScheduleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding: ScheduleItemBinding? = DataBindingUtil.bind(view)
}