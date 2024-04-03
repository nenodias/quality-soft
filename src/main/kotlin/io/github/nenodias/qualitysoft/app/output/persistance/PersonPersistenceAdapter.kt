package io.github.nenodias.qualitysoft.app.output.persistance

import io.github.nenodias.qualitysoft.app.output.persistance.mapper.toDomain
import io.github.nenodias.qualitysoft.app.output.persistance.mapper.toEntity
import io.github.nenodias.qualitysoft.app.output.persistance.repository.PersonRepository
import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.output.PersistPersonPortOut
import org.springframework.stereotype.Component


@Component
class PersonPersistenceAdapter(
        val personRepository: PersonRepository
) : PersistPersonPortOut {
    override fun persist(person: Person):Person {
        return personRepository.saveAndFlush(person.toEntity()).toDomain()
    }
}