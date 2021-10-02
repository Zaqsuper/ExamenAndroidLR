package com.example.examenandroidlr.datares
import com.google.gson.annotations.SerializedName

data class HeroesResLite(
    @SerializedName("response") var response:String,
    @SerializedName("id") var id:String,
    @SerializedName("name") var name:String,
    @SerializedName("url") var image:String
)
