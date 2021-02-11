package com.albertcid.madridapp.data.model

import com.google.gson.annotations.SerializedName

data class NetworkCenterAddress(
    @SerializedName("locality")val locality: String? = null,
    @SerializedName("postal-code")val postalCode: Long? = null,
    @SerializedName("street-address")val streetAddress: String? = null,
)

