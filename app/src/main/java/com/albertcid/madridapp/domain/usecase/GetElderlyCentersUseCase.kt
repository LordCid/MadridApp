package com.albertcid.madridapp.domain.usecase

import com.albertcid.madridapp.domain.model.Center
import io.reactivex.Observable

interface GetElderlyCentersUseCase {
    operator fun invoke(): Observable<List<Center>>
}