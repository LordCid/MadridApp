package com.albertcid.madridapp.data.model

import com.google.gson.annotations.SerializedName

data class NetworkDataWrapper (
    @SerializedName("@graph") val graph: List<NetworkCenterModel>? = null
)