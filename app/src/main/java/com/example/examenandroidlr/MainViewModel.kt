package com.example.examenandroidlr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examenandroidlr.datares.HeroesResLite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel: ViewModel(){

    private var isLoading = false
    private var limit = 1

    private val _progressVisibility = MutableLiveData<Boolean>()
    val progressVisibility: LiveData<Boolean> get() = _progressVisibility

    private val _statusError = MutableLiveData<Boolean>()
    val statusError: LiveData<Boolean> get() = _statusError

    val heroeLiveList: MutableLiveData<MutableList<HeroesResLite>> = MutableLiveData<MutableList<HeroesResLite>>()

    fun getHeroeLite(){
        val heroeList: MutableList<HeroesResLite> = mutableListOf<HeroesResLite>()
        isLoading = true
        _progressVisibility.value = true

        CoroutineScope(Dispatchers.Main).launch {
            for(i in limit until limit+10){
                val call = getRetrofit().create(APIService::class.java).getHeroesLite("$i/image")
                val heroe : HeroesResLite? = call.body()
                if(call.isSuccessful){
                    if(heroe!=null){
                        heroeList.add(heroe)
                    }
                } else{
                    _statusError.value = true
                }
            }
            isLoading = false
            _progressVisibility.value = false
            heroeLiveList.value = heroeList
        }
    }

    fun checkScroll(visibleItemCount: Int?, pastVisibleItem: Int, total: Int){
        if(!isLoading){
            if (visibleItemCount != null) {
                if((visibleItemCount+pastVisibleItem) >= total){
                    limit = limit + 10
                    getHeroeLite()
                }
            }
        }
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/api/4356232994459398/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}