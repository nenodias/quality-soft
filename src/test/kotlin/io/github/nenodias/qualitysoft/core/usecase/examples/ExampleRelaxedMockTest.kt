package io.github.nenodias.qualitysoft.core.usecase.examples

import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.output.PersistPersonPortOut
import io.github.nenodias.qualitysoft.core.usecase.CreatePersonService
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExampleRelaxedMockTest {

    private lateinit var repository: PersistPersonPortOut
    private lateinit var usecase: CreatePersonService

    @BeforeEach
    fun setup() {
        this.repository = mockk(relaxed = true)
        this.usecase = CreatePersonService(repository)
    }

    @Test
    fun `should create a person`() {
        val person = Person(null,"Misty Williams", "Gym Leader")
        val actual = this.usecase.createPerson(person)
        println("Person: ${person.id}, ${person.name}, ${person.profile}")
        println("Actual: ${actual.id}, ${actual.name}, ${actual.profile}")
        assert(actual != person)
    }
}