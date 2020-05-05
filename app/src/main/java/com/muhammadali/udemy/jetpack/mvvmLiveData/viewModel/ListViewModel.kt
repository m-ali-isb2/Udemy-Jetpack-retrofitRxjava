package com.muhammadali.udemy.jetpack.mvvmLiveData.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammadali.udemy.jetpack.mvvmLiveData.model.DogBreed
import kotlin.random.Random

/**
 * Created by Muhammad Ali on 04-May-20.
 * Email muhammad.ali9385@gmail.com
 */
class ListViewModel:ViewModel {

    val dogs = MutableLiveData<List<DogBreed>>()
    val error = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    var dogList = ArrayList<DogBreed>()
    var dogList2 = ArrayList<DogBreed>()

    constructor() {
        dummyData()
    }


    fun dummyData() {
        val dogBreed1 = DogBreed("1", "GermanShepherd", "10", "unknown", "Normal", "")
        val dogBreed2 = DogBreed("2", "Pointer", "12", "unknown", "High", "")
        val dogBreed3 = DogBreed("3", "Bully", "14", "unknown", "Low", "")

        dogList = arrayListOf<DogBreed>(dogBreed1, dogBreed2, dogBreed3)
    }

    fun refresh() {

        dogList2.clear()
        for (i in 0..2) {
            dogList2?.add(dogList[(0..2).random()])
        }

        dogs.value = dogList2
        error.value = false
        loading.value = false

    }

}