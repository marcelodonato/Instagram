package com.marcelodonato.instagram.post

import android.net.Uri
import com.marcelodonato.instagram.common.base.BasePresenter
import com.marcelodonato.instagram.common.base.BaseView
import com.marcelodonato.instagram.common.model.Post
import com.marcelodonato.instagram.common.model.UserAuth

interface Post {

    interface Presenter : BasePresenter {
        fun fetchPictures()

    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayFullPictures(posts: List<Uri>)
        fun displayEmptyPictures()
        fun displayRequestFailure(message: String)


    }
}