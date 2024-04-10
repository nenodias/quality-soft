package io.github.nenodias.qualitysoft.core.usecase

import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.output.PersistPersonPortOut
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CreatePersonServiceTest {

    private lateinit var repository: PersistPersonPortOut
    private lateinit var usecase: CreatePersonService

    @BeforeEach
    fun setup() {
        this.repository = mockk(relaxed = true)
        every { repository.persist(any()) } answers { firstArg() }
        this.usecase = CreatePersonService(repository)
    }

    @Test
    fun `should create a person`() {
        val person = Person(null,"Brock Harrison", "Gym Leader")
        val actual = this.usecase.createPerson(person)
        assert(actual == person)
    }
}