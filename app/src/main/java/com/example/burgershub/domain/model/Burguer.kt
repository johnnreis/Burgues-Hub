package com.example.burgershub.domain.model

data class Burguer(
    val desc: String?,
    val id: Int?,
    val images: List<Image?>?,
    val ingredients: List<Ingredient?>?,
    val name: String?,
    val price: Double?,
    val veg: Boolean?
)
