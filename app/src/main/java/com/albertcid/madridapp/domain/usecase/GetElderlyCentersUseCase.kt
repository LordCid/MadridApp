package com.albertcid.madridapp.domain.usecase

import com.albertcid.madridapp.domain.model.Center
import io.reactivex.Single

interface GetElderlyCentersUseCase {
    operator fun invoke(): Single<List<Center>>
}