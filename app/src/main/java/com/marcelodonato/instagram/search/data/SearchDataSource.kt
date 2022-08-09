package com.marcelodonato.instagram.search.data

import com.marcelodonato.instagram.common.base.RequestCallback
import com.marcelodonato.instagram.common.model.UserAuth

interface SearchDataSource {
    fun fetchUsers(name: String, callback: RequestCallback<List<UserAuth>>)
}