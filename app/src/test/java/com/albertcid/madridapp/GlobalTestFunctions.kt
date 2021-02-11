package com.albertcid.madridapp

import com.albertcid.madridapp.data.model.NetworkCenterAddress
import com.albertcid.madridapp.data.model.NetworkCenterDescription
import com.albertcid.madridapp.data.model.NetworkCenterModel
import com.albertcid.madridapp.domain.model.Center

private val networkAddress = NetworkCenterAddress(
    locality = "Madrid",
    postalCode = 0,
    streetAddress = "streetAddress"
)

private val networkDescription = NetworkCenterDescription(
    description = "description",
    schedule = "schedule",
    services = "services",
    name = "name"
)

fun getNetworkCenterModel(id: Long) = NetworkCenterModel(
    id = id,
    title = "title",
    relation = "relation",
    address = networkAddress,
    description = networkDescription
)

fun getOtherNetworkCenterModel(id: Long) = NetworkCenterModel(
    id = id,
    title = "otherTitle",
    relation = "other relation",
    address = networkAddress,
    description = networkDescription
)

fun getCenter(id: Long) = Center(
    id = id,
    title = "title",
    relation = "relation",
    locality = "Madrid",
    postalCode = 0,
    streetAddress = "streetAddress",
    description = "description",
    schedule = "schedule",
    services = "services",
    name = "name",
)
fun getOtherCenter(id: Long) = Center(
    id = id,
    title = "otherTitle",
    relation = "other relation",
    locality = "Madrid",
    postalCode = 0,
    streetAddress = "streetAddress",
    description = "description",
    schedule = "schedule",
    services = "services",
    name = "name",
)

