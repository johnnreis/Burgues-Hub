package com.example.burgershub.domain.model

import com.example.burgershub.data.model.ImageResponse
import com.example.burgershub.data.model.IngredientResponse

data class Burguer(
    val desc: String?,
    val id: Int?,
    val images: List<ImageResponse?>?,
    val ingredients: List<IngredientResponse?>?,
    val name: String?,
    val price: Double?,
    val veg: Boolean?
)
