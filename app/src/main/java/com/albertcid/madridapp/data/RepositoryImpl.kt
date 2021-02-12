package com.albertcid.madridapp.data

import com.albertcid.madridapp.domain.model.Center
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val networkDatasource: NetworkDatasource
) : Repository {
    override fun getElderlyCenters() = networkDatasource.getElderlyCenters()
    override fun getFamilyCenters(): Single<List<Center>> = networkDatasource.getFamilyCenters()
}