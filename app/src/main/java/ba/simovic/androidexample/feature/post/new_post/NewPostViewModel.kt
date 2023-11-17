package ba.simovic.androidexample.feature.post.new_post

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.simovic.androidexample.data.model.Post
import ba.simovic.androidexample.use_case.post.AddPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewPostViewModel @Inject constructor(
    private val addPostUseCase: AddPostUseCase
) : ViewModel() {

    data class NewPostModel(
        val isLoading: Boolean = false,
        val title: String = "",
        val text: String = "",
        val isError: Boolean = false,
        val navigation: NewPostNavigation? = null
    )

    var state by mutableStateOf(NewPostModel())

    enum class NewPostNavigation {
        NAVIGATE_UP
    }

    fun navigationFinished() {
        viewModelScope.launch {
            state = state.copy(navigation = null)
        }
    }

    fun addNewPost() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true)
                val it = addPostUseCase.run(Post(id = 0, title = state.title, text = state.text))
                state = state.copy(navigation = NewPostNavigation.NAVIGATE_UP)
            } catch (e: Exception) {
                state = state.copy(isLoading = false, isError = true)
            }
        }
    }

    fun setData(
        title: String = state.title,
        text: String = state.text,
        isError: Boolean = state.isError
    ) {
        viewModelScope.launch {
            state = state.copy(title = title, text = text, isError = isError)
        }
    }
}
