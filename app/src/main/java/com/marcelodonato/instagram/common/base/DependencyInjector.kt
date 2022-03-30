package com.marcelodonato.instagram.common.base

import com.marcelodonato.instagram.login.data.FakeDataSource
import com.marcelodonato.instagram.login.data.LoginRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository{
        return LoginRepository(FakeDataSource())
    }
}