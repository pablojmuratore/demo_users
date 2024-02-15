package com.pablojmuratore.demousers.features.users.datastates

import com.pablojmuratore.demousers.features.users.models.User

sealed class UsersState {
    data object Undefined : UsersState()
    data object Loading : UsersState()
    data class Error(val message: String? = null) : UsersState()
    data class Loaded(val users: List<User>) : UsersState()
}