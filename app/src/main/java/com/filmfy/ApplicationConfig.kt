package com.filmfy

import android.app.Application
import android.content.Context
import com.filmfy.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationConfig : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: ApplicationConfig? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ApplicationConfig)
            modules(listOf(applicationModule))
        }
    }
}