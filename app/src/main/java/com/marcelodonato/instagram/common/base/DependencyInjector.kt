package com.marcelodonato.instagram.common.base


import com.marcelodonato.instagram.login.data.FakeDataSource
import com.marcelodonato.instagram.login.data.LoginRepository
import com.marcelodonato.instagram.register.data.FakeRegisterDataSource
import com.marcelodonato.instagram.register.data.RegisterRepository
import com.marcelodonato.instagram.splash.data.FakeLocalDataSource
import com.marcelodonato.instagram.splash.data.SplashRepository

object DependencyInjector {

  fun splashRepository() : SplashRepository {
    return SplashRepository(FakeLocalDataSource())
  }

  fun loginRepository() : LoginRepository {
    return LoginRepository(FakeDataSource())
  }

  fun registerEmailRepository() : RegisterRepository {
    return RegisterRepository(FakeRegisterDataSource())
  }

}