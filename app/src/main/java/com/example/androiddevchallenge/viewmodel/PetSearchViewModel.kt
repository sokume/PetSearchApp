package com.example.androiddevchallenge.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Pet

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
            Pet("Charlie","POODLES", "2020/04","CA", R.drawable.dog1, sampleNote),
            Pet("Rocky","PEMBROKE WELSH CORGIS", "2020/03","CA",R.drawable.dog2, sampleNote),
            Pet("LILY","SCOTTISH FOLD", "2020/05","DC",R.drawable.cat1, sampleNote),
            Pet("Lola","YORKSHIRE TERRIERS", "2020/03","AZ", R.drawable.dog3, sampleNote),
            Pet("Maggie","POMERANIAN", "2020/08","FL",R.drawable.dog4, sampleNote),
            Pet("CHARLIE","AMERICAN SHORT HAIR", "2020/05","DC",R.drawable.cat2, sampleNote),
            Pet("Toby","YORKSHIRE TERRIERS", "2020/03","DC", R.drawable.dog5, sampleNote),
            Pet("Lucy","RETRIEVERS (GOLDEN) ", "2019/12","MT",R.drawable.dog6, sampleNote),
            Pet("TIGER","OTHER", "2020/05","MT",R.drawable.cat3, sampleNote),
            Pet("Tama","OTHER", "2020/07","FL",R.drawable.cat4, sampleNote),
            Pet("Buchi","OTHER", "2020/06","FL",R.drawable.cat5, sampleNote),
            Pet("Sophie","SHIH TZU", "2020/07","ME", R.drawable.dog7, sampleNote),
            Pet("Cooper","OTHER", "2020/08","NY",R.drawable.dog8, sampleNote),
        )
    }

    fun setPet(pet : Pet?){
        selectedPet = pet
        petCheckedCount = INITIAL_COUNT
        petDetailNote = pet?.notes?.get(petCheckedCount - 1) ?: ""
    }

    fun checkCountUp(){
        try {
            petCheckedCount++
            petDetailNote = selectedPet?.notes?.get(petCheckedCount - 1) ?: ""
        }catch (exception : Exception){
            selectedPet = null
            petCheckedCount = INITIAL_COUNT
        }
    }

    companion object{
        private const val INITIAL_COUNT = 1
    }



}