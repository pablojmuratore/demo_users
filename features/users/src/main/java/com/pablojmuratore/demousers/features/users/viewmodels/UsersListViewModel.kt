package com.pablojmuratore.demousers.features.users.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablojmuratore.demousers.features.users.datastates.UsersState
import com.pablojmuratore.demousers.features.users.repositories.IUsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val usersRepository: IUsersRepository
) : ViewModel() {
    private val _users = MutableStateFlow<UsersState>(UsersState.Undefined)
    val users: StateFlow<UsersState> = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _users.emit(UsersState.Loading)

                val networkUsers = usersRepository.getNetworkUsers()

                _users.emit(UsersState.Loaded(networkUsers))
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _users.emit(UsersState.Error())
            }
        }
    }
}