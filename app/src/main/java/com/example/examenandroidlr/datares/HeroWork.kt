package com.example.examenandroidlr.datares

import com.google.gson.annotations.SerializedName

data class HeroWork(
    @SerializedName("occupation") var occupation:String,
    @SerializedName("base") var base:String
)
