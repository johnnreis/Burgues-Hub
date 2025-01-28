package com.example.burgershub.data.api

import com.example.burgershub.data.model.BurgerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceAPI {

    @GET("burgers")
    suspend fun getBurgers(): List<BurgerResponse>

    @GET("burgers/{burgers_id}")
    suspend fun getBurgersById(
        @Path("burgers_id") burgerId: Int
    ): BurgerResponse

    @GET("find-burger/")
    suspend fun getBurgersByName(
      @Query("search")  name: String
    ): List<BurgerResponse>

}