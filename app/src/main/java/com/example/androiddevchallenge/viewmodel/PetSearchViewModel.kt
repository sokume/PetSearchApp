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

    var selectedPet : Pet? by mutableStateOf(null)
    private set

    var petList: List<Pet> by mutableStateOf(listOf())

    var petDetailNote : String by mutableStateOf("")

    var petCheckedCount : Int by mutableStateOf(INITIAL_COUNT)

    private val sampleNote = listOf<String>(
    "Note1 \nHe barks a lot until he gets used to it.",
    "Note2 \nGo for a walk every day.",
    "Note3 \nOwning a pet is very expensive.",
    "Note4 \nKeep the room you live in together clean.",
    "Note5 \nClean up your dog's droppings.",
    "Note6 \nIf you notice any changes in your pet, please take it to the hospital.",
    "Note7 \nAre you healthy?",
    "Note8 \nDoes everyone in your family want to have a pet?",
    "Note9 \nDo you have someone to talk to when you can no longer take care of your pet?",
    "Note10 \nCan you take responsibility for your pet's life?",
    "Finish \nWe contacted the foster parents. Please watch and wait for the dreams of having fun with pets.",
)



    init {
        petList = listOf(
            Pet(1,"pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog1, sampleNote),
            Pet(2,"ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog2, sampleNote),
            Pet(3,"pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog3, sampleNote),
            Pet(4,"ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog4, sampleNote),
            Pet(5,"pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog5, sampleNote),
            Pet(6,"ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog6, sampleNote),
            Pet(7,"pochi",AnimalType.Dog, Date(),"tokyo", R.drawable.dog7, sampleNote),
            Pet(8,"ken",AnimalType.Cat, Date(),"tokyo",R.drawable.dog8, sampleNote),
        )
    }

    fun setPet(pet : Pet){
        selectedPet = pet
        petCheckedCount = INITIAL_COUNT
        petDetailNote = pet.notes[petCheckedCount]
    }

    fun checkCountUp(){
        petCheckedCount++
        petDetailNote = selectedPet?.notes?.get(petCheckedCount - 1) ?: ""
    }

    companion object{
        private const val INITIAL_COUNT = 1
    }



}