package ba.simovic.androidexample.feature.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.simovic.androidexample.use_case.authentication.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val signInUseCase: SignInUseCase) : ViewModel() {

    data class LoginModel(
        val email: String = "test@test.com",
        val password: String = "test",
        val isSuccess: Boolean = false,
        val isError: Boolean = false
    )

    var state by mutableStateOf(LoginModel())

    fun login() {
        viewModelScope.launch {
            state = try {
                val isSuccess = signInUseCase.run(state.email, state.password)
                state.copy(isSuccess = isSuccess, isError = false)
            } catch (e: Exception) {
                state.copy(isSuccess = false, isError = true)
            }
        }
    }

    fun setData(
        email: String = state.email,
        password: String = state.password,
        isError: Boolean = state.isError
    ) {
        viewModelScope.launch {
            state = state.copy(email = email, password = password, isError = isError)
        }
    }

    fun signingIn() {
        viewModelScope.launch {
            state = state.copy(isSuccess = false)
        }
    }
}
