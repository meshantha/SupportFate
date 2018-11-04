package com.kalum.wheel.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.MenuItem
import com.kalum.wheel.R
import com.kalum.wheel.databinding.ActivityMainBinding
import com.kalum.wheel.ui.schedules.SchedulesFragment
import com.kalum.wheel.ui.users.UsersFragment
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG_USER_FRAGMENT = "users_list"
    private val TAG_SCHEDULE_FRAGMENT = "schedules_list"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.view_pager, UsersFragment(), TAG_USER_FRAGMENT)
                    .commit()
        }
        setupViews(savedInstanceState)
    }

    private fun setupViews(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.fab.setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.view_pager, SchedulesFragment(), TAG_SCHEDULE_FRAGMENT)
                        .commit()
            }
        }

        setupToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.getItemId() == android.R.id.home) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.view_pager, UsersFragment(), TAG_USER_FRAGMENT)
                    .commit()
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.includeToolbar?.toolbar)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }


}