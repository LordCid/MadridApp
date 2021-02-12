package com.albertcid.madridapp.domain.usecase

import com.albertcid.madridapp.domain.model.Center
import io.reactivex.Observable
import io.reactivex.Single

interface GetFamilyCentersUseCase {
    operator fun invoke(): Single<List<Center>>
}