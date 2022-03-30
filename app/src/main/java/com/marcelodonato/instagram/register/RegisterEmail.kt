package com.marcelodonato.instagram.register

import androidx.annotation.StringRes
import com.marcelodonato.instagram.common.base.BasePresenter
import com.marcelodonato.instagram.common.base.BaseView

interface RegisterEmail {

    interface Presenter : BasePresenter{
        fun create(email: String)
    }

    interface View : BaseView<Presenter> {
        fun displayEmailFailure(@StringRes emailError : Int?)
    }

}