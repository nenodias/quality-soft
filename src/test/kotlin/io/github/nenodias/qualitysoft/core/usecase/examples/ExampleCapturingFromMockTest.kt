package io.github.nenodias.qualitysoft.core.usecase.examples

import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.output.PersistPersonPortOut
import io.github.nenodias.qualitysoft.core.usecase.CreatePersonNewService
import io.mockk.Ordering
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExampleCapturingFromMockTest {

    private lateinit var repository: PersistPersonPortOut
    private lateinit var usecase: CreatePersonNewService
    private val personSlot = slot<Person>()

    @BeforeEach
    fun setup() {
        this.repository = mockk()
        this.usecase = spyk(CreatePersonNewService(repository))
        every { repository.persist(capture(personSlot)) } answers {
            personSlot.captured
        }
    }

    @Test
    fun `should create a person`() {
        val person = Person(null, "Misty Williams", "Gym Leader")
        val actual = this.usecase.createPerson(person)
        // ordering = Ordering.ORDERED garante que a ordem das chamadas seja respeitada, mas permite outras chamadas
        verify(ordering = Ordering.ORDERED) {
            usecase.createPerson(person)
            repository.persist(personSlot.captured)
        }
        assert(actual.id != null)
        Assertions.assertEquals(personSlot.captured.id, actual.id)
        Assertions.assertEquals(person.name, actual.name)
        Assertions.assertEquals(person.profile, actual.profile)
    }
}