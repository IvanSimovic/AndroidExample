package ba.simovic.androidexample.feature.post.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.simovic.androidexample.data.model.Post
import ba.simovic.androidexample.use_case.post.FetchPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsUseCase: FetchPostsUseCase
) : ViewModel() {

    data class PostsModel(
        val isLoading: Boolean = false,
        val posts: List<Post> = listOf(),
    )

    var state by mutableStateOf(PostsModel())

    init {
        getPosts()
    }

    fun getPosts() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading =  true)
                val result = postsUseCase.run(Unit)
                state = state.copy(posts = result, isLoading =  false)
            } catch (e: Exception) {
                delay(2000)
                getPosts()
            }
        }
    }
}
