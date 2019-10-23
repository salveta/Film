package com.filmfy.app.base

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.Disposable

abstract class GenericActivity: AppCompatActivity() {

    protected lateinit var eventListener: Disposable

    override fun onDestroy() {
        super.onDestroy()
        if (::eventListener.isInitialized && !eventListener.isDisposed) {
            eventListener.dispose()
        }
    }
}