package com.kalum.wheel.domain.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Kalum Fernando on 11/1/2018.
 */
@Entity(tableName = "users")
data class User(
        @field:PrimaryKey(autoGenerate = true)
        val userId :Int,
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String
)