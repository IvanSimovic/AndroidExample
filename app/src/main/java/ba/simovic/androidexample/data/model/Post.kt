package ba.simovic.androidexample.data.model

import ba.simovic.androidexample.data.local.post.PostEntity

data class Post (
    val id: Long = 0,
    val title: String = "",
    val text: String = ""
)

fun PostEntity.toPost() = Post(id, title, text)
fun List<PostEntity>.toPost() = this.map { it.toPost() }

fun Post.toPostEntity() = PostEntity(0, title, text)