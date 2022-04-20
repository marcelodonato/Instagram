package com.marcelodonato.instagram.profile

import com.marcelodonato.instagram.common.base.BasePresenter
import com.marcelodonato.instagram.common.base.BaseView
import com.marcelodonato.instagram.common.model.Post
import com.marcelodonato.instagram.common.model.UserAuth

interface Profile {

    interface Presenter : BasePresenter {
        fun fetchUserProfile()
        fun fetchUserPosts()
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled : Boolean)
        fun displayUserProfile(userAuth: UserAuth)
        fun displayRequestFailure(message : String)
        fun displayEmptyPosts()
        fun displayFullPosts(posts : List<Post>)
    }
}