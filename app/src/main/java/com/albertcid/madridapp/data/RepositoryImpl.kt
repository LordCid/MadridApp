package com.albertcid.madridapp.data

import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val networkDatasource: NetworkDatasource
) : Repository {
    override fun getElderlyCenters() = networkDatasource.getElderlyCenters()
    override fun getFamilyCenters() = networkDatasource.getFamilyCenters()
}