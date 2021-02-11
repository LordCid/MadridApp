package com.albertcid.madridapp.data.model

import com.google.gson.annotations.SerializedName

data class NetworkCenterDescription (
    @SerializedName("organization-desc")val description: String? = null,
    @SerializedName("schedule")val schedule: String? = null,
    @SerializedName("services")val services: String? = null,
    @SerializedName("organization-name")val name: String? = null
)
