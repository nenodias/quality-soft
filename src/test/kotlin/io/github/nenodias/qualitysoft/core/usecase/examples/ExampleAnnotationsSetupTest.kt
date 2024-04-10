package io.github.nenodias.qualitysoft.core.usecase.examples

import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.output.PersistPersonPortOut
import io.github.nenodias.qualitysoft.core.usecase.CreatePersonService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class ExampleAnnotationsSetupTest {

    @MockK
    private lateinit var repository: PersistPersonPortOut

    @InjectMockKs
    private lateinit var usecase: CreatePersonService

    @BeforeEach
    fun setup() {
        every { repository.persist(any()) } answers { firstArg() }
    }

    @Test
    fun `should create a person`() {
        val person = Person(null,"Ash Ketchum", "Pokemon Trainer")
        val actual = this.usecase.createPerson(person)
        verify(exactly = 1) {
            usecase.createPerson(person)
            repository.persist(person)
        }
        assert(actual == person)
    }
}