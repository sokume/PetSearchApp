package com.example.androiddevchallenge.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.AnimalType
import com.example.androiddevchallenge.model.Pet
import java.util.*

class PetSearchViewModel : ViewModel() {

    var petList: List<Pet> by mutableStateOf(listOf())

    init {
        petList = listOf(
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
            Pet("pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1),
            Pet("ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2),
        )
    }


}