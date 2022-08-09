package com.marcelodonato.instagram.common.model

import android.net.Uri
import com.marcelodonato.instagram.common.model.Database.usersAuth
import java.io.File
import java.util.*

object Database {

    val usersAuth = mutableListOf<UserAuth>()
    val posts = hashMapOf<String, MutableSet<Post>>()
    val feeds = hashMapOf<String, MutableSet<Post>>()
    val followers = hashMapOf<String, Set<String>>()

    var sessionAuth: UserAuth? = null

    init {
        val userA = UserAuth(
            UUID.randomUUID().toString(),
            "UserA",
            "userA@gmail.com",
            "12345678",
            Uri.fromFile(File("/storage/emulated/0/Android/media/com.marcelodonato.instagram/Instagram/2022-33-19-02-33-53-470.jpg"))
        )
        val userB = UserAuth(
            UUID.randomUUID().toString(),
            "UserB",
            "userB@gmail.com",
            "87654321",
            Uri.fromFile(File("/storage/emulated/0/Android/media/com.marcelodonato.instagram/Instagram/2022-33-19-02-33-53-470.jpg"))
        )

        usersAuth.add(userA)
        usersAuth.add(userB)

        followers[userA.uuid] = hashSetOf()
        posts[userA.uuid] = hashSetOf()
        feeds[userA.uuid] = hashSetOf()

        followers[userB.uuid] = hashSetOf()
        posts[userB.uuid] = hashSetOf()
        feeds[userB.uuid] = hashSetOf()

        for (i in 0..30) {
            val user =
                UserAuth(
                    UUID.randomUUID().toString(),
                    "user$i",
                    "user$i@gmail.com",
                    "123123123",
                    null
                )
            usersAuth.add(user)
        }

        sessionAuth = usersAuth.first()
    }

}