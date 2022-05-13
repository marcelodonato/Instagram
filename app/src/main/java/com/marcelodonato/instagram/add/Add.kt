package com.marcelodonato.instagram.add

import com.marcelodonato.instagram.common.base.BasePresenter
import com.marcelodonato.instagram.common.base.BaseView

interface Add {

    interface Presenter: BasePresenter{

    }

    interface View : BaseView<Presenter>{

    }
}