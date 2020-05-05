package com.muhammadali.udemy.jetpack.mvvmLiveData.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammadali.udemy.jetpack.mvvmLiveData.model.DogBreed

/**
 * Created by Muhammad Ali on 05-May-20.
 * Email muhammad.ali9385@gmail.com
 */
class DetailViewModel : ViewModel() {


    val dogObj = MutableLiveData<DogBreed>()

    fun setDetails(dogBreed: DogBreed) {
        dogObj.value = dogBreed
    }
}