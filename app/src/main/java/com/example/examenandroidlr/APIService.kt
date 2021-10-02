package com.example.examenandroidlr

import com.example.examenandroidlr.datares.HeroesRes
import com.example.examenandroidlr.datares.HeroesResLite
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getHeroesLite(@Url url:String):Response<HeroesResLite>

    @GET
    suspend fun getHeroes(@Url url:String):Response<HeroesRes>
}