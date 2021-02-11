package com.albertcid.madridapp.di

import com.albertcid.madridapp.presentation.list.CenterListActivity
import com.albertcid.madridapp.presentation.list.CenterListPresenter
import com.albertcid.madridapp.presentation.list.CentersListContract
import dagger.Binds
import dagger.Module

@Module
interface ElderlyCenterListModule {
    @Binds
    fun bindPresenter(presenter: CenterListPresenter): CentersListContract.Presenter

    @Binds
    fun bindView(view: CenterListActivity): CentersListContract.View
}
