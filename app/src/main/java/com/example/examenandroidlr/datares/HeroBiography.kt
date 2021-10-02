package com.example.examenandroidlr.datares

import com.google.gson.annotations.SerializedName

data class HeroBiography(
    @SerializedName("full-name") var fullName:String,
    @SerializedName("alter-egos") var alterEgos:String,
    @SerializedName("aliases") var aliases:List<String>,
    @SerializedName("place-of-birth") var placeBirth:String,
    @SerializedName("first-appearance") var firstAppearance:String,
    @SerializedName("publisher") var publisher:String,
    @SerializedName("alignment") var alignment:String
)
