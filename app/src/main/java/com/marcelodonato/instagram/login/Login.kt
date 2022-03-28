package com.marcelodonato.instagram.login

import com.marcelodonato.instagram.common.base.BasePresenter
import com.marcelodonato.instagram.common.base.BaseView

interface Login : BasePresenter{

    // presenter
    interface Presenter: BasePresenter{
        fun login(email : String, password: String)

    }

    // camada view
    interface View : BaseView<Presenter> {
        fun showProgress(enabled : Boolean)
        fun displayEmailFailure(emailError : Int?)
        fun displayPasswordFailure(passwordError : Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)

    }


}