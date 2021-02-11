package com.albertcid.madridapp.di

import com.albertcid.madridapp.data.ApiService
import com.albertcid.madridapp.domain.SchedulerProvider
import com.albertcid.madridapp.domain.SchedulerProviderImpl
import dagger.Module
import dagger.Provides

@Module
object ProvidesModule {
    @Provides
    @JvmStatic
    fun providesApiService() = ApiService.create()

    @Provides
    @JvmStatic
    fun provideIoScheduler(): SchedulerProvider = SchedulerProviderImpl()
}
