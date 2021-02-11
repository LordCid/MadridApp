package com.albertcid.madridapp.domain

import com.albertcid.madridapp.data.model.NetworkDataWrapper
import com.albertcid.madridapp.data.model.NetworkCenterModel
import com.albertcid.madridapp.domain.model.Center
import com.albertcid.madridapp.domain.model.CenterCategory

fun NetworkDataWrapper.toCenterElderlyModel(): List<Center> {
    return graph?.map { it.toCenterElderlyModel() }.orEmpty()
}

private fun NetworkCenterModel.toCenterElderlyModel() = Center(
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
    category = CenterCategory.ELDER
)

fun NetworkDataWrapper.toFamilyElderlyModel(): List<Center> {
    return graph?.map { it.toFamilyElderlyModel() }.orEmpty()
}

fun NetworkCenterModel.toFamilyElderlyModel() = Center(
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
    category = CenterCategory.FAMILY
)