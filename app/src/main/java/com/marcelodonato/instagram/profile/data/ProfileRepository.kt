package com.marcelodonato.instagram.profile.data

import com.marcelodonato.instagram.common.base.RequestCallback
import com.marcelodonato.instagram.common.model.Post
import com.marcelodonato.instagram.common.model.UserAuth

class ProfileRepository(private val dataSource: ProfileDataSource) {

    fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>) {
        dataSource.fetchUserProfile(userUUID, callback)
    }

    fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
        dataSource.fetchUserPosts(userUUID, callback)
    }
}