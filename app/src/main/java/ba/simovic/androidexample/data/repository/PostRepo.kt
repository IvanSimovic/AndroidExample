package ba.simovic.androidexample.data.repository

import ba.simovic.androidexample.data.local.post.PostDao
import ba.simovic.androidexample.data.model.Post
import ba.simovic.androidexample.data.model.toPost
import ba.simovic.androidexample.data.model.toPostEntity
import javax.inject.Inject

class PostRepo @Inject constructor(private val postDao: PostDao) {

    suspend fun getPosts(): List<Post> = postDao.select().toPost()

    suspend fun addPost(post: Post) {
        postDao.insert(post.toPostEntity())
    }

    suspend fun getPost(id: Long) = postDao.select(id).toPost()

}