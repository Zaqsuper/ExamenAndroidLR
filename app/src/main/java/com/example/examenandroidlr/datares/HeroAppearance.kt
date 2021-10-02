package com.example.examenandroidlr.datares

import com.google.gson.annotations.SerializedName

data class HeroAppearance(
    @SerializedName("gender") var gender:String,
    @SerializedName("race") var race:String,
    @SerializedName("height") var heigth:List<String>,
    @SerializedName("weight") var weight:List<String>,
    @SerializedName("eye-color") var eyeColor:String,
    @SerializedName("hair-color") var hairColor:String
)
