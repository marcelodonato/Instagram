package com.marcelodonato.instagram.profile.data

import com.marcelodonato.instagram.common.base.RequestCallback
import com.marcelodonato.instagram.common.model.Post
import com.marcelodonato.instagram.common.model.UserAuth

interface ProfileDataSource {

    fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>)
    fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>)

}