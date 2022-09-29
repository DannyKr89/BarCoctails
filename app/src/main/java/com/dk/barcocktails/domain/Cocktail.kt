package com.dk.barcocktails.domain

data class Cocktail(
    var titleCocktail: String,
    var descCocktailColOne: String,
    var descCocktailColTwo: String,
    var misc: String,
    var image_id: Int = 0
)