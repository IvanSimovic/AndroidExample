package ba.simovic.androidexample.feature.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(): ViewModel() {

    data class State(
        val email: String = "test@test.com",
        val isSuccess: Boolean = false
    )

    var state by mutableStateOf(State())

    fun setEmail(email: String) {
        viewModelScope.launch {
            state = state.copy(email = email)
        }
    }

}