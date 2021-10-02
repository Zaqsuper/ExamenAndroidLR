package com.example.examenandroidlr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examenandroidlr.datares.HeroesRes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailViewModel : ViewModel() {

    private val _statusError = MutableLiveData<Boolean>()
    val statusError: LiveData<Boolean> get() = _statusError

    private val _tvHeroId = MutableLiveData<String>()
    val tvHeroId: LiveData<String> get() = _tvHeroId

    private val _tvHeroName = MutableLiveData<String>()
    val tvHeroName: LiveData<String> get() = _tvHeroName

    private val _tvHeroImage = MutableLiveData<String>()
    val tvHeroImage: LiveData<String> get() = _tvHeroImage

    private val _tvHeroIntelligent = MutableLiveData<String>()
    val tvHeroIntelligent: LiveData<String> get() = _tvHeroIntelligent

    private val _tvHeroStrength = MutableLiveData<String>()
    val tvHeroStrength: LiveData<String> get() = _tvHeroStrength

    private val _tvHeroSpeed = MutableLiveData<String>()
    val tvHeroSpeed: LiveData<String> get() = _tvHeroSpeed

    private val _tvHeroDurability = MutableLiveData<String>()
    val tvHeroDurability: LiveData<String> get() = _tvHeroDurability

    private val _tvHeroPower = MutableLiveData<String>()
    val tvHeroPower: LiveData<String> get() = _tvHeroPower

    private val _tvHeroCombat = MutableLiveData<String>()
    val tvHeroCombat: LiveData<String> get() = _tvHeroCombat

    private val _tvHeroFullName = MutableLiveData<String>()
    val tvHeroFullName: LiveData<String> get() = _tvHeroFullName

    private val _tvHeroAlterEgos = MutableLiveData<String>()
    val tvHeroAlterEgos: LiveData<String> get() = _tvHeroAlterEgos

    private val _tvHeroAliases = MutableLiveData<String>()
    val tvHeroAliases: LiveData<String> get() = _tvHeroAliases

    private val _tvHeroPlaceBirthday = MutableLiveData<String>()
    val tvHeroPlaceBirthday: LiveData<String> get() = _tvHeroPlaceBirthday

    private val _tvHeroFirstAppearance = MutableLiveData<String>()
    val tvHeroFirstAppearance: LiveData<String> get() = _tvHeroFirstAppearance

    private val _tvHeroPublisher = MutableLiveData<String>()
    val tvHeroPublisher: LiveData<String> get() = _tvHeroPublisher

    private val _tvHeroAlignment = MutableLiveData<String>()
    val tvHeroAlignment: LiveData<String> get() = _tvHeroAlignment

    private val _tvHeroGender = MutableLiveData<String>()
    val tvHeroGender: LiveData<String> get() = _tvHeroGender

    private val _tvHeroRace = MutableLiveData<String>()
    val tvHeroRace: LiveData<String> get() = _tvHeroRace

    private val _tvHeroHeigth = MutableLiveData<String>()
    val tvHeroHeigth: LiveData<String> get() = _tvHeroHeigth

    private val _tvHeroWeigth = MutableLiveData<String>()
    val tvHeroWeigth: LiveData<String> get() = _tvHeroWeigth

    private val _tvHeroEyeColor = MutableLiveData<String>()
    val tvHeroEyeColor: LiveData<String> get() = _tvHeroEyeColor

    private val _tvHeroHairColor = MutableLiveData<String>()
    val tvHeroHairColor: LiveData<String> get() = _tvHeroHairColor

    private val _tvHeroOcupation = MutableLiveData<String>()
    val tvHeroOcupation: LiveData<String> get() = _tvHeroOcupation

    private val _tvHeroBase = MutableLiveData<String>()
    val tvHeroBase: LiveData<String> get() = _tvHeroBase

    private val _tvHeroGroupAffilation = MutableLiveData<String>()
    val tvHeroGroupAffilation: LiveData<String> get() = _tvHeroGroupAffilation

    private val _tvHeroRelatives = MutableLiveData<String>()
    val tvHeroRelatives: LiveData<String> get() = _tvHeroRelatives

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/api/4356232994459398/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getHeroeAll(query:String){
        CoroutineScope(Dispatchers.Main).launch {
            val call = getRetrofit().create(APIService::class.java).getHeroes("$query")
            val hero : HeroesRes? = call.body()
            if(call.isSuccessful){
                if(hero!=null){
                    loadDataHero(hero)
                }
            } else{
                _statusError.value = true
            }
        }
    }

    fun loadDataHero(hero: HeroesRes) {
        _tvHeroImage.value = hero.url_image.image
        _tvHeroId.value = hero.id
        _tvHeroName.value = hero.name

        _tvHeroIntelligent.value = hero.powerstats.intelligence
        _tvHeroStrength.value = hero.powerstats.strength
        _tvHeroSpeed.value = hero.powerstats.speed
        _tvHeroDurability.value = hero.powerstats.durability
        _tvHeroPower.value = hero.powerstats.power
        _tvHeroCombat.value = hero.powerstats.combat

        _tvHeroFullName.value = hero.biography.fullName
        _tvHeroAlterEgos.value = hero.biography.alterEgos
        _tvHeroAliases.value = hero.biography.aliases.toString()
        _tvHeroPlaceBirthday.value = hero.biography.placeBirth
        _tvHeroFirstAppearance.value = hero.biography.firstAppearance
        _tvHeroPublisher.value = hero.biography.publisher
        _tvHeroAlignment.value = hero.biography.alignment

        _tvHeroGender.value = hero.appearance.gender
        _tvHeroRace.value = hero.appearance.race
        _tvHeroHeigth.value = hero.appearance.heigth.toString()
        _tvHeroWeigth.value = hero.appearance.weight.toString()
        _tvHeroEyeColor.value = hero.appearance.eyeColor
        _tvHeroHairColor.value = hero.appearance.hairColor

        _tvHeroOcupation.value = hero.work.occupation
        _tvHeroBase.value = hero.work.base

        _tvHeroGroupAffilation.value = hero.connections.groupAffilation
        _tvHeroRelatives.value = hero.connections.relatives

    }
}