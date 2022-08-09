package com.marcelodonato.instagram.search

import com.marcelodonato.instagram.common.base.BasePresenter
import com.marcelodonato.instagram.common.base.BaseView
import com.marcelodonato.instagram.common.model.UserAuth

interface Search {
    interface Presenter : BasePresenter {
        fun fetchUser(name: String)
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayFullUsers(users: List<UserAuth>)
        fun displayEmptyUsers()
    }

}