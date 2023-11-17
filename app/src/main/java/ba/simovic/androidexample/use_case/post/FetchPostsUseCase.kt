package ba.simovic.androidexample.use_case.post

import ba.simovic.androidexample.data.model.Post
import ba.simovic.androidexample.data.repository.PostRepo
import javax.inject.Inject

class FetchPostsUseCase @Inject constructor(
    private val postRepo: PostRepo
) {

    suspend fun run(input: Unit): List<Post> {
        return postRepo.getPosts()
    }

}
