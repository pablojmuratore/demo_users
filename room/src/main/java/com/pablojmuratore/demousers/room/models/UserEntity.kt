package com.pablojmuratore.demousers.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName: String,
    val email: String? = null,
    val phone: String? = null,
    val website: String? = null
)