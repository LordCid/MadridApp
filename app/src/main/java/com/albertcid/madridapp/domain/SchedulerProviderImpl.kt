package com.albertcid.madridapp.domain

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulerProviderImpl @Inject constructor(): SchedulerProvider {
    override fun io() = Schedulers.io()
    override fun ui() = AndroidSchedulers.mainThread()
}