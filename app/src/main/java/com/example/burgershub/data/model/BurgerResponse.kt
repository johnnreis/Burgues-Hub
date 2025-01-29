package com.example.burgershub.data.model

import com.google.gson.annotations.SerializedName

data class BurgerResponse(
    val desc: String?,
    val id: Int?,
    @SerializedName("images")
    val imagesResponse: List<ImageResponse?>?,
    @SerializedName("ingredients")
    val ingredientsResponse: List<IngredientResponse?>?,
    val name: String?,
    val price: Float?,
    val veg: Boolean?
)
