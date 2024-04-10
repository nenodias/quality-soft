package io.github.nenodias.qualitysoft.core.usecase.examples

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExamplePartialMockTest {

    class Calculator {
        fun increment(num: Int) = num + 1
    }

    @Test
    fun `should add one to a number`() {
        val calculator = mockk<Calculator>()

        // Mockando chamadas para retornar -1
        every { calculator.increment(any()) } returns -1
        // Quando for o valor 3, chamar o método original
        every { calculator.increment(3) } answers { callOriginal() }

        assertEquals(-1, calculator.increment(2))
        assertEquals(4, calculator.increment(3))
    }
}