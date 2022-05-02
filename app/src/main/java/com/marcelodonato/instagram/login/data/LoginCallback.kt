package com.marcelodonato.instagram.login.data

import com.marcelodonato.instagram.common.model.UserAuth


interface LoginCallback {
    fun onSuccess(userAuth: UserAuth)
    fun onFailure(message: String)
    fun onComplete()
}