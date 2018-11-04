package com.kalum.wheel.ui.users

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kalum.wheel.R
import com.kalum.wheel.domain.model.User
import com.kalum.wheel.ui.base.BaseAdapter

class UsersAdapter constructor(list: List<User>) : BaseAdapter<User>(list) {

    override fun onCreateViewHolderBase(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(LayoutInflater
                .from(parent?.context)
                .inflate(R.layout.user_item, parent, false))
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder?, position: Int) {
        val binding = (holder as UserViewHolder).binding
        val user = list[position]
        binding?.user = user
    }

}