package com.marcelodonato.instagram.search.presentation

import com.marcelodonato.instagram.common.base.RequestCallback
import com.marcelodonato.instagram.common.model.UserAuth
import com.marcelodonato.instagram.search.Search
import com.marcelodonato.instagram.search.data.SearchRepository


class SearchPresenter(
    private var view: Search.View?,
    private val repository: SearchRepository
) : Search.Presenter {

    override fun fetchUser(name: String) {
        view?.showProgress(true)
        repository.fetchUser(name , object : RequestCallback<List<UserAuth>> {
            override fun onSuccess(data: List<UserAuth>) {
                if (data.isEmpty()) {
                    view?.displayEmptyUsers()
                } else {
                    view?.displayFullUsers(data)
                }
            }

            override fun onFailure(message: String) {
                view?.displayEmptyUsers()
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


