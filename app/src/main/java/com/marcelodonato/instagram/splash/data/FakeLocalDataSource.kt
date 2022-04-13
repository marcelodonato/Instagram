package com.marcelodonato.instagram.splash.data

import com.marcelodonato.instagram.common.model.Database


class FakeLocalDataSource : SplashDataSource {
  override fun session(callback: SplashCallback) {
    if (Database.sessionAuth != null) {
      callback.onSuccess()
    } else {
      callback.onFailure()
    }
  }
}