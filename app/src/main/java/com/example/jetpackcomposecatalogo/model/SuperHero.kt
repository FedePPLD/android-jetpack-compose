package com.example.jetpackcomposecatalogo.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var heroName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
