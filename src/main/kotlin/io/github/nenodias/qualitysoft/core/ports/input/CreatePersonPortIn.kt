package io.github.nenodias.qualitysoft.core.ports.input

import io.github.nenodias.qualitysoft.core.domain.Person

interface CreatePersonPortIn {
    fun createPerson(person: Person):Person
}