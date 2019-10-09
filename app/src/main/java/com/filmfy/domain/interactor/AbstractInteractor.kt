package com.filmfy.domain.interactor

import io.reactivex.disposables.Disposable

abstract class AbstractInteractor  {
    var disposable: Disposable? = null

    protected fun clearComposite() {
        if (disposable != null) {
            disposable?.dispose()
        }
    }
}