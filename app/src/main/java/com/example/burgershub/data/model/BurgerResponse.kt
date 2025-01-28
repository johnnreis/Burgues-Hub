package com.example.burgershub.data.model

data class BurgerResponse(
    val desc: String?,
    val id: Int?,
    val imagesResponse: List<ImageResponse?>?,
    val ingredientsResponse: List<IngredientResponse?>?,
    val name: String?,
    val price: Double?,
    val veg: Boolean?
)
