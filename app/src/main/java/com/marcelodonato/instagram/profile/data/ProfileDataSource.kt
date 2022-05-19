package com.marcelodonato.instagram.profile.data

import com.marcelodonato.instagram.common.base.RequestCallback
import com.marcelodonato.instagram.common.model.Post
import com.marcelodonato.instagram.common.model.UserAuth
import java.lang.UnsupportedOperationException

interface ProfileDataSource {

    fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>)

    fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>)

    fun fetchSession() : UserAuth { throw UnsupportedOperationException() }

    fun putUser(response: UserAuth) { throw UnsupportedOperationException() }

    fun putPosts(response: List<Post>?) { throw UnsupportedOperationException() }

}