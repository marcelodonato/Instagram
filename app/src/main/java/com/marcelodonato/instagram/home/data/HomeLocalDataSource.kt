package com.marcelodonato.instagram.home.data

import com.marcelodonato.instagram.common.base.Cache
import com.marcelodonato.instagram.common.base.RequestCallback
import com.marcelodonato.instagram.common.model.Database
import com.marcelodonato.instagram.common.model.Post
import com.marcelodonato.instagram.common.model.UserAuth
import java.lang.RuntimeException

class HomeLocalDataSource(private val feedCache: Cache<List<Post>>
) : HomeDataSource {

    override fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>) {
        val posts = feedCache.get(userUUID)
        if (posts != null) {
            callback.onSuccess(posts)
        } else {
            callback.onFailure("Posts não existem")
        }
        callback.onComplete()
    }

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw RuntimeException("User not found ")
    }

    override fun putFeed(response: List<Post>?) {
        feedCache.put(response)
    }
}