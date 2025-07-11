package com.artem.clone.jetnews.data.posts.impl

import com.artem.clone.jetnews.model.Post
import com.artem.clone.jetnews.model.PostsFeed
import kotlinx.coroutines.flow.Flow

interface PostsRepository {

    suspend fun getPost(postId: String?) : Result<Post>

    suspend fun getPostsFeed() : Result<PostsFeed>

    fun observeFavorites() : Flow<Set<String>>
    //fun observeFavorites() : Flow<Set<String>>
    fun observePostsFeed() : Flow<String?>

    suspend fun toggleFavorite(postId: String)

}