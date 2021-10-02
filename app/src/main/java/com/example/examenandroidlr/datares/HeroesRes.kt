package com.example.examenandroidlr.datares

import com.google.gson.annotations.SerializedName

data class HeroesRes(
    @SerializedName("response") var response:String,
    @SerializedName("id") var id:String,
    @SerializedName("name") var name:String,

    //Powerstats
    @SerializedName("powerstats") var powerstats: HeroPowerstats,

    //Biography
    @SerializedName("biography") var biography: HeroBiography,

    //Appearance
    @SerializedName("appearance") var appearance: HeroAppearance,

    //Work
    @SerializedName("work") var work: HeroWork,

    //Connections
    @SerializedName("connections") var connections: HeroConnections,

    //Image
    @SerializedName("image") var url_image: HeroImage
)
