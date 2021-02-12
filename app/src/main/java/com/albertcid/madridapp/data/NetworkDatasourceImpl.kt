package com.albertcid.madridapp.data

import com.albertcid.madridapp.domain.model.Center
import com.albertcid.madridapp.domain.toCenterElderlyModel
import com.albertcid.madridapp.domain.toFamilyElderlyModel
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class NetworkDatasourceImpl @Inject constructor(
    private val apiService: ApiService
) : NetworkDatasource {
    override fun getElderlyCenters(): Single<List<Center>> {
        return apiService.getElderlyCenter().map { it.toCenterElderlyModel() }
    }

    override fun getFamilyCenters(): Single<List<Center>> {
        return apiService.getFamiliyCenter().map { it.toFamilyElderlyModel() }
    }
}