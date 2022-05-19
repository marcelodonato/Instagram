package com.marcelodonato.instagram.add.data

import com.marcelodonato.instagram.common.model.Database
import com.marcelodonato.instagram.common.model.UserAuth
import java.lang.RuntimeException

class AddLocalDataSource : AddDataSource {

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw RuntimeException("Usuário não logado!!")
    }
}