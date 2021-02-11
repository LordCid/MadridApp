package com.albertcid.madridapp.domain.usecase

import com.albertcid.madridapp.data.Repository
import javax.inject.Inject

class GetElderlyCentersUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetElderlyCentersUseCase {
    override fun invoke() = repository.getElderlyCenters()
}