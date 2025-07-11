package com.artem.clone.jetnews.data.posts.impl

interface PostsRepository {
    suspend fun getPost(postId: String?) : Result<Post>
}