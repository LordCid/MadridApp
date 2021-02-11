package com.albertcid.madridapp.data.model

import com.google.gson.annotations.SerializedName

data class NetworkCenterModel (
    @SerializedName("id")val id: Long? = null,
    @SerializedName("title")val title: String? = null,
    @SerializedName("relation")val relation: String? = null,
    @SerializedName("address")val address: NetworkCenterAddress? = null,
    @SerializedName("organization")val description: NetworkCenterDescription? = null
)

