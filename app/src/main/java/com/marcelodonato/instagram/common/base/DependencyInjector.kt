package com.marcelodonato.instagram.common.base


import android.content.Context
import com.marcelodonato.instagram.add.data.AddFakeRemoteDataSource
import com.marcelodonato.instagram.add.data.AddLocalDataSource
import com.marcelodonato.instagram.add.data.AddRepository
import com.marcelodonato.instagram.home.data.FeedMemoryCache
import com.marcelodonato.instagram.home.data.HomeDataSourceFactory
import com.marcelodonato.instagram.home.data.HomeRepository
import com.marcelodonato.instagram.login.data.FakeDataSource
import com.marcelodonato.instagram.login.data.LoginRepository
import com.marcelodonato.instagram.post.data.PostLocalDataSource
import com.marcelodonato.instagram.post.data.PostRepository
import com.marcelodonato.instagram.profile.data.*
import com.marcelodonato.instagram.register.data.FakeRegisterDataSource
import com.marcelodonato.instagram.register.data.RegisterRepository
import com.marcelodonato.instagram.search.data.SearchDataSource
import com.marcelodonato.instagram.search.data.SearchFakeRemoteDataSource
import com.marcelodonato.instagram.search.data.SearchRepository
import com.marcelodonato.instagram.splash.data.FakeLocalDataSource
import com.marcelodonato.instagram.splash.data.SplashRepository


object DependencyInjector {

    fun splashRepository(): SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }

    fun profileRepository(): ProfileRepository {
        return ProfileRepository(ProfileDataSourceFactory(ProfileMemoryCache, PostListMemoryCache))
    }

    fun searchRepository(): SearchRepository {
        return SearchRepository(SearchFakeRemoteDataSource())
    }

    fun homeRepository(): HomeRepository {
        return HomeRepository(HomeDataSourceFactory(FeedMemoryCache))
    }

    fun addRepository(): AddRepository {
        return AddRepository(AddFakeRemoteDataSource(), AddLocalDataSource())
    }

    fun postRepository(context: Context): PostRepository {
        return PostRepository(PostLocalDataSource(context))
    }

}