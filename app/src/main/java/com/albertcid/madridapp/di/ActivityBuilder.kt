package com.albertcid.madridapp.di


import com.albertcid.madridapp.presentation.list.CenterListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        DomainModule::class,
        DataModule::class,
        ProvidesModule::class
    ]
)
interface ActivityBuilder {
    @ContributesAndroidInjector(modules = [ElderlyCenterListModule::class])
    fun bindElderlyCenterListActivity(): CenterListActivity

}