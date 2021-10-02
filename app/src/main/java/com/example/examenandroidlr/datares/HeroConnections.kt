package com.example.examenandroidlr.datares

import com.google.gson.annotations.SerializedName

data class HeroConnections(
    @SerializedName("group-affiliation") var groupAffilation:String,
    @SerializedName("relatives") var relatives:String
)
