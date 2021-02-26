package com.example.androiddevchallenge.model

import java.util.*


data class Pet(
    val name : String,
    val type : AnimalType,
    val birthday : Date,
    val origin : String,
    val drawableImageId : Int
)

enum class AnimalType{
    Dog,Cat
}
