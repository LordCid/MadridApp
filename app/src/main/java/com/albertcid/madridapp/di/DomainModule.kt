package com.albertcid.madridapp.di

import com.albertcid.madridapp.domain.usecase.GetElderlyCentersUseCase
import com.albertcid.madridapp.domain.usecase.GetElderlyCentersUseCaseImpl
import com.albertcid.madridapp.domain.usecase.GetFamilyCentersUseCase
import com.albertcid.madridapp.domain.usecase.GetFamilyCentersUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindGetElderlyCentersUseCase(usecase: GetElderlyCentersUseCaseImpl): GetElderlyCentersUseCase

    @Binds
    fun bindGetFamilyCentersUseCase(usecase: GetFamilyCentersUseCaseImpl): GetFamilyCentersUseCase
}
