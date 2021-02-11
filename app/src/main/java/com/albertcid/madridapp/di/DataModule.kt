package com.albertcid.madridapp.di

import com.albertcid.madridapp.data.NetworkDatasource
import com.albertcid.madridapp.data.NetworkDatasourceImpl
import com.albertcid.madridapp.data.Repository
import com.albertcid.madridapp.data.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindNetworkDataSource(dataSource: NetworkDatasourceImpl): NetworkDatasource

    @Binds
    fun bindRepository(repository: RepositoryImpl): Repository
}
