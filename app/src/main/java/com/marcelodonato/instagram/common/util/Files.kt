package com.marcelodonato.instagram.common.util

import android.app.Activity
import com.marcelodonato.instagram.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object Files {

    private const val FILENAME_FORMAT = "yyyy-mm-dd-hh-mm-ss-SSS"

    fun generateFile(activity: Activity) : File{
       val mediaDir =  activity.externalMediaDirs.firstOrNull()?.let{
            File(it, activity.getString(
                R.string.app_name )).apply {
                    mkdirs()
            }
        }

        val outputDir = if(mediaDir != null && mediaDir.exists())
            mediaDir else activity.filesDir

        return File(outputDir, SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis()) + ".jpg")
    }

}