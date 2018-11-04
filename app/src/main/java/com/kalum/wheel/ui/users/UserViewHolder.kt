package com.kalum.wheel.ui.users

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.kalum.wheel.databinding.UserItemBinding


class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: UserItemBinding? = DataBindingUtil.bind(view)

}