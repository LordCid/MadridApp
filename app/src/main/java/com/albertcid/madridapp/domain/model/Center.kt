package com.albertcid.madridapp.domain.model


data class Center(
    val id: Long,
    val title: String,
    val relation: String,
    val locality: String,
    val postalCode: Long,
    val streetAddress: String,
    val description: String,
    val schedule: String,
    val services: String,
    val name: String,
    val category: CenterCategory
)

enum class CenterCategory { ELDER, FAMILY }
