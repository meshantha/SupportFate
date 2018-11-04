package com.kalum.wheel.ui.users

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.kalum.wheel.domain.model.User
import java.util.Collections.emptyList

/**
 * * Created by Kalum Fernando on 11/1/2018.
 */

object ListUsersBindings {

    @JvmStatic
    @BindingAdapter("load_users")
    fun loadUsers(recyclerView: RecyclerView, users: List<User>?) {
        recyclerView.adapter = if (users != null) UsersAdapter(users) else UsersAdapter(emptyList())
    }


}