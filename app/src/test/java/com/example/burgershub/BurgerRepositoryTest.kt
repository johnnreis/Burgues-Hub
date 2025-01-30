package com.example.burgershub

import com.example.burgershub.data.api.ServiceAPI
import com.example.burgershub.data.model.BurgerResponse
import com.example.burgershub.data.model.ImageResponse
import com.example.burgershub.data.model.IngredientResponse
import com.example.burgershub.data.repository.BurgerRepositoryImpl
import com.example.burgershub.domain.repository.BurgerRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BurgerRepositoryTest {

    // create return of request
    private lateinit var serviceAPI: ServiceAPI

    private lateinit var burgerRepository: BurgerRepository

    @Before
    fun setUp() {
        serviceAPI = mockk()
        burgerRepository = BurgerRepositoryImpl(serviceAPI)
    }

    @Test
    fun `test getBurgers returns list of burgers`() = runTest {

        val imageResponseList = ImageResponse(lg = "", sm = "")
        val ingredientResponseList = IngredientResponse(id = 0, img = "", name = "")

        val fakeResponse = listOf(
            BurgerResponse(
                desc = "Lorem ispum",
                id = 0,
                imagesResponse = listOf(imageResponseList),
                ingredientsResponse = listOf(ingredientResponseList),
                name = "lorem ispum",
                price = 10.98f,
                veg = false

            )
        )

        coEvery { serviceAPI.getBurgers() } returns fakeResponse

        val result = burgerRepository.getBurgers()

        assertEquals(fakeResponse, result)

    }

}