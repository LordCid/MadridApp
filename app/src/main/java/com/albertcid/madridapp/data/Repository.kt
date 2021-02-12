package com.albertcid.madridapp.data

import com.albertcid.madridapp.domain.model.Center
import io.reactivex.Single

interface Repository {
    fun getElderlyCenters(): Single<List<Center>>
    fun getFamilyCenters(): Single<List<Center>>
}