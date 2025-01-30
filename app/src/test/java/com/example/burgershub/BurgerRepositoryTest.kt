package com.example.burgershub

import com.example.burgershub.data.model.BurgerResponse
import com.example.burgershub.data.model.ImageResponse
import com.example.burgershub.data.model.IngredientResponse
import com.example.burgershub.domain.repository.BurgerRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BurgerRepositoryTest {

    // create mock of BurgerRepository
    private lateinit var burgerRepository: BurgerRepository

    @Before
    fun setup() {
        burgerRepository = mockk()
    }

    @Test
    fun `test for getBurgers if returns list of burgers`() = runTest {

        // simulate response API
        val fakeBurgers = listOf(
            BurgerResponse("Lorem Ispum",
                imagesResponse = listOf(ImageResponse(sm = "", lg = "")),
                id = 1,
                ingredientsResponse = listOf(
                    IngredientResponse(
                        id = 0,
                        img = "burger image",
                        name = "BigMac"
                    )
                ),
                name = "",
                price = 10.98f,
                veg = false
            ),
            BurgerResponse("Lorem Ispum",
                imagesResponse = listOf(ImageResponse(sm = "", lg = "")),
                id = 1,
                ingredientsResponse = listOf(
                    IngredientResponse(
                        id = 0,
                        img = "burger image",
                        name = "BigMac"
                    )
                ),
                name = "",
                price = 10.98f,
                veg = false
            )

        )


        coEvery { burgerRepository.getBurgers() } returns fakeBurgers

        val result = burgerRepository.getBurgers()

        assertEquals(fakeBurgers, result)

    }

}