package com.albertcid.madridapp.domain.usecase

import com.albertcid.madridapp.data.Repository
import com.albertcid.madridapp.domain.model.Center
import io.reactivex.Single
import javax.inject.Inject

class GetElderlyCentersUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetElderlyCentersUseCase {
    override fun invoke() = repository.getElderlyCenters()
}