package com.albertcid.madridapp.domain.usecase

import com.albertcid.madridapp.data.Repository
import javax.inject.Inject

class GetFamilyCentersUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetFamilyCentersUseCase {
    override fun invoke() = repository.getFamilyCenters()
}