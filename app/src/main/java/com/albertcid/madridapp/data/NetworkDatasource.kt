package com.albertcid.madridapp.data

import com.albertcid.madridapp.domain.model.Center
import io.reactivex.Observable

interface NetworkDatasource {
    fun getElderlyCenters(): Observable<List<Center>>
    fun getFamilyCenters(): Observable<List<Center>>
}