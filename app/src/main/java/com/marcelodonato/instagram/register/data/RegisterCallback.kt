package com.marcelodonato.instagram.register.data

import com.marcelodonato.instagram.common.model.UserAuth

interface RegisterCallback {
    fun onSuccess()
    fun onFailure(message : String)
    fun onComplete()

}