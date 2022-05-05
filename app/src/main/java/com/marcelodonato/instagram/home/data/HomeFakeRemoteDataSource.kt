package com.marcelodonato.instagram.home.data

import android.os.Handler
import android.os.Looper
import com.marcelodonato.instagram.common.base.RequestCallback
import com.marcelodonato.instagram.common.model.Database
import com.marcelodonato.instagram.common.model.Post
import com.marcelodonato.instagram.common.model.UserAuth

class HomeFakeRemoteDataSource : HomeDataSource {

    override fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val feed = Database.feeds[userUUID]

            callback.onSuccess(feed?.toList() ?: emptyList())

            callback.onComplete()
        }, 2000)
    }
}