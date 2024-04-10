package io.github.nenodias.qualitysoft.core.usecase.examples

import io.mockk.every
import io.mockk.spyk
import io.mockk.verifySequence
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExamplePrivateMockTest {
    class Car {
        fun drive() = accelerate()

        private fun accelerate() = "going faster"
    }

    @Test
    fun `should drive a car`() {
        val mock = spyk<Car>(recordPrivateCalls = true)

        every { mock["accelerate"]() } returns "going not so fast"

        assertEquals("going not so fast", mock.drive())

        verifySequence {
            mock.drive()
            mock["accelerate"]()
        }
    }
}