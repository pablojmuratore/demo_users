package com.pablojmuratore.demousers.features.users.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablojmuratore.demousers.features.users.repositories.IUsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val usersRepository: IUsersRepository,
) : ViewModel() {
    val users = usersRepository.getUsersFlow()
        .stateIn(scope = viewModelScope, initialValue = emptyList(), started = SharingStarted.WhileSubscribed(5_000L))

    init {
        loadNetworkUsers()
    }

    private fun loadNetworkUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                usersRepository.loadNetworkUsers()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.d("---x", "loadUsers ( UsersListViewModel ) - ERROR: ${e.message}")
            }
        }
    }
}
