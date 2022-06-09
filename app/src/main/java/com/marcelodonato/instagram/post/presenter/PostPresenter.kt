package com.marcelodonato.instagram.post.presenter

import com.marcelodonato.instagram.post.Post
import com.marcelodonato.instagram.post.data.PostRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class PostPresenter(
    private var view: Post.View?,
    private val repository: PostRepository
) : Post.Presenter, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    override fun fetchPictures() {
        view?.showProgress(true)

        launch {
            val pictures = repository.fetchPictures()

            withContext(Dispatchers.Main) {
                if (pictures.isEmpty()) {
                    view?.displayEmptyPictures()
                } else {
                    view?.displayFullPictures(pictures)
                }
                view?.showProgress(false)
            }
        }
    }

    override fun onDestroy() {
        job.cancel()
        view = null
    }

}