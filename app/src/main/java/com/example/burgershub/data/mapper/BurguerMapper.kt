package com.example.burgershub.data.mapper

import com.example.burgershub.data.model.BurgerResponse
import com.example.burgershub.data.model.ImageResponse
import com.example.burgershub.data.model.IngredientResponse
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.domain.model.Image
import com.example.burgershub.domain.model.Ingredient

fun BurgerResponse.toDomain() = Burger(
    desc = this.desc,
    id = this.id,
    images = this.imagesResponse?.map { it?.toDomain() },
    ingredients = this.ingredientsResponse?.map { it?.toDomain() },
    name = this.name,
    price = this.price,
    veg = this.veg

)

fun ImageResponse.toDomain() = Image(
    lg = this.lg,
    sm = this.sm
)

fun IngredientResponse.toDomain() = Ingredient(
    id = this.id,
    name = this.name,
    img = this.img
)