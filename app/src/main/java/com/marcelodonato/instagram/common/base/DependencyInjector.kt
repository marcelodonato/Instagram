package com.marcelodonato.instagram.common.base

import com.marcelodonato.instagram.login.data.FakeDataSource
import com.marcelodonato.instagram.login.data.LoginRepository
import com.marcelodonato.instagram.register.data.FakeRegisterDataSource
import com.marcelodonato.instagram.register.data.RegisterRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository{
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }

}