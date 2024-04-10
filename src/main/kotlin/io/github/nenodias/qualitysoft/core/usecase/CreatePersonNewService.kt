package io.github.nenodias.qualitysoft.core.usecase

import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.input.CreatePersonPortIn
import io.github.nenodias.qualitysoft.core.ports.output.PersistPersonPortOut
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class CreatePersonNewService(
    private val persistPersonPortOut: PersistPersonPortOut
): CreatePersonPortIn {

    override fun createPerson(person: Person): Person {
        val id = Random(System.currentTimeMillis()).nextLong()
        return persistPersonPortOut.persist(person.copy(id = id))
    }
}