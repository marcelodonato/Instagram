package com.marcelodonato.instagram.splash.presentation

import com.marcelodonato.instagram.splash.Splash
import com.marcelodonato.instagram.splash.data.SplashCallback
import com.marcelodonato.instagram.splash.data.SplashRepository


class SplashPresenter(
  private var view: Splash.View?,
  private val repository: SplashRepository
) : Splash.Presenter {

  override fun authenticated() {
    repository.session(object : SplashCallback {
      override fun onSuccess() {
        view?.goToMainScreen()
      }

      override fun onFailure() {
        view?.goToLoginScreen()
      }
    })

  }

  override fun onDestroy() {
    view = null
  }

}