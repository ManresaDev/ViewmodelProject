package com.aire.viewmodelproject.data

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    val info : Info? = null,
    @SerializedName("results") val characters : List<Character>? = null
)
