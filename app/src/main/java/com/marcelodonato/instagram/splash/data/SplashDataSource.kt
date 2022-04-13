package com.marcelodonato.instagram.splash.data


interface SplashDataSource {
  fun session(callback: SplashCallback)
}