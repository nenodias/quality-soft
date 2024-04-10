package io.github.nenodias.qualitysoft.core.usecase.examples

import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.output.PersistPersonPortOut
import io.github.nenodias.qualitysoft.core.usecase.CreatePersonService
import io.mockk.Ordering
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExampleSpyMockTest {

    private lateinit var repository: PersistPersonPortOut
    private lateinit var usecase: CreatePersonService

    @BeforeEach
    fun setup() {
        this.repository = mockk()
        //Sem o spyk o teste falha, pois o verify não consegue verificar a chamada do método
        this.usecase = spyk(CreatePersonService(repository))
        every { repository.persist(any()) } answers {
            Person(
                id = 1,
                name = firstArg<Person>().name,
                profile = firstArg<Person>().profile,
            )
        }
    }

    @Test
    fun `should create a person`() {
        val person = Person(null, "Misty Williams", "Gym Leader")
        val actual = this.usecase.createPerson(person)
        // Existem outros tipos de verificadores como
        // verifyAll - verifica todas as chamadas
        // verifyOrder - verifica a ordem das chamadas
        // verifySequence - verifica a sequência das chamadas e se não houve outras chamadas
        verify(ordering = Ordering.SEQUENCE) {
            usecase.createPerson(person)
            repository.persist(person)
        }
        assert(actual.id != null)
        Assertions.assertEquals(person.name, actual.name)
        Assertions.assertEquals(person.profile, actual.profile)
        //exactly = 1, atLeast= 1, atMost = 1, são permitidos quando as chamadas não são ordenadas
        //inverse = true, verifica se a chamada não foi feita da forma especificada
    }
}