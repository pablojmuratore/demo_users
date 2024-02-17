package com.pablojmuratore.demousers.features.users.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablojmuratore.demousers.features.users.models.User
import com.pablojmuratore.demousers.features.users.repositories.IUsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val usersRepository: IUsersRepository
) : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun loadUserInfo(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = usersRepository.getUserById(userId)

            _user.emit(user)
        }
    }
}