package com.albertcid.madridapp.data

import com.albertcid.madridapp.domain.model.Center
import com.albertcid.madridapp.domain.toDomainModel
import io.reactivex.Observable
import javax.inject.Inject

class NetworkDatasourceImpl @Inject constructor(
    private val apiService: ApiService
) : NetworkDatasource {
    override fun getElderlyCenters(): Observable<List<Center>> {
        return apiService.getElderlyCenter().map { it.toDomainModel() }
    }

    override fun getFamilyCenters(): Observable<List<Center>> {
        return apiService.getFamiliyCenter().map { it.toDomainModel() }
    }
}