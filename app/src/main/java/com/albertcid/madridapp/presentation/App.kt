package com.albertcid.madridapp.presentation


import com.albertcid.madridapp.di.AppComponent
import com.albertcid.madridapp.di.AppComponentFactory
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class App : DaggerApplication() {

    open lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = AppComponentFactory.create(this)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}
