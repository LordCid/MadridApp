package com.albertcid.madridapp.di

import android.app.Application
import com.albertcid.madridapp.presentation.App
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module(includes = [AndroidInjectionModule::class])
interface AppModule {

    @Binds
    @Singleton
    fun application(app: App): Application
}