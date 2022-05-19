package com.marcelodonato.instagram.home.presentation

import com.marcelodonato.instagram.common.base.RequestCallback
import com.marcelodonato.instagram.common.model.Post
import com.marcelodonato.instagram.home.Home
import com.marcelodonato.instagram.home.data.HomeRepository


class HomePresenter(
    private var view: Home.View?,
    private val repository: HomeRepository
) : Home.Presenter {

    override fun clear() {
       repository.clearCache()
    }

    override fun fetchFeed() {
        view?.showProgress(true)
        repository.fetchFeed(object : RequestCallback<List<Post>> {
            override fun onSuccess(data: List<Post>) {
                if (data.isEmpty()) {
                    view?.displayEmptyPosts()
                } else {
                    view?.displayFullPosts(data)
                }
            }

            override fun onFailure(message: String) {
                view?.displayRequestFailure(message)
            }

            override fun onComplete() {
                view?.showProgress(false)
            }
        })
    }

    override fun onDestroy() {
        view = null
    }
}