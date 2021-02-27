package com.example.androiddevchallenge.model

import java.util.*


data class Pet(
    val id : Int,
    val name : String,
    val type : AnimalType,
    val birthday : Date,
    val origin : String,
    val drawableImageId : Int,
    val notes : List<String>
)

enum class AnimalType{
    Dog,Cat
}
