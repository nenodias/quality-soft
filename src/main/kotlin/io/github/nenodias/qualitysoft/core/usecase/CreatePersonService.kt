package io.github.nenodias.qualitysoft.core.usecase

import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.input.CreatePersonPortIn
import io.github.nenodias.qualitysoft.core.ports.output.PersistPersonPortOut
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Primary
@Service
class CreatePersonService(
        private val persistPersonPortOut: PersistPersonPortOut
): CreatePersonPortIn {

    override fun createPerson(person: Person): Person {
        return persistPersonPortOut.persist(person)
    }
}