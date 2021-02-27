package com.example.androiddevchallenge.model

import java.util.*


data class Pet(
    val name : String,
    val type : String,
    val birthday : String,
    val origin : String,
    val drawableImageId : Int,
    val notes : List<String>
)

