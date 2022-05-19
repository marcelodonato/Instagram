package com.marcelodonato.instagram.profile.data

import com.marcelodonato.instagram.R
import com.marcelodonato.instagram.common.base.Cache
import com.marcelodonato.instagram.common.base.RequestCallback
import com.marcelodonato.instagram.common.model.Database
import com.marcelodonato.instagram.common.model.Post
import com.marcelodonato.instagram.common.model.UserAuth
import java.lang.RuntimeException

class ProfileLocalDataSource(
    private val profileCache: Cache<UserAuth>,
    private val postsCache: Cache<List<Post>>,
) : ProfileDataSource {

    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>) {
        val userAuth = profileCache.get(userUUID)
        if (userAuth != null) {
            callback.onSuccess(userAuth)
        } else {
            callback.onFailure("Usuário não encontrado")
        }
        callback.onComplete()
    }

    override fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
        val posts = postsCache.get(userUUID)
        if (posts != null) {
            callback.onSuccess(posts)
        } else {
            callback.onFailure("posts não existem")
        }
        callback.onComplete()
    }

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw RuntimeException("usuário não logado!!!")
    }

    override fun putUser(response: UserAuth) {
        profileCache.put(response)
    }

    override fun putPosts(response: List<Post>?) {
        postsCache.put(response)
    }

}