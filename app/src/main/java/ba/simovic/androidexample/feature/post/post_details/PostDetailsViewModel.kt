package ba.simovic.androidexample.feature.post.post_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.simovic.androidexample.data.model.Post
import ba.simovic.androidexample.use_case.post.FetchPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(private val fetchPostUseCase: FetchPostUseCase) :
    ViewModel() {

    data class PostDetailsModel(
        val isLoading: Boolean = false,
        val post: Post = Post()
    )

    var state by mutableStateOf(PostDetailsModel())

    fun getPost(id: Long) {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true)
                val result = fetchPostUseCase.run(id)
                state = state.copy(isLoading = false, post = result)
            } catch (e: Exception) {
                delay(2000)
                getPost(id)
            }
        }
    }
}
