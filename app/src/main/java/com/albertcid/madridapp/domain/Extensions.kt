package com.albertcid.madridapp.domain

import com.albertcid.madridapp.data.model.NetworkDataWrapper
import com.albertcid.madridapp.data.model.NetworkCenterModel
import com.albertcid.madridapp.domain.model.Center

fun NetworkDataWrapper.toDomainModel(): List<Center> {
    return graph?.map { it.toDomainModel() }.orEmpty()
}

private fun NetworkCenterModel.toDomainModel() = Center(
    id = id ?: 0,
    title = title ?: "",
    relation = relation ?: "",
    locality = address?.locality ?: "",
    postalCode = address?.postalCode ?: 0,
    streetAddress = address?.streetAddress ?: "",
    description = description?.description ?: "",
    schedule = description?.schedule ?: "",
    services = description?.services ?: "",
    name = description?.name ?: "",
)