package io.github.nenodias.qualitysoft.core.ports.output

import io.github.nenodias.qualitysoft.core.domain.Person

interface PersistPersonPortOut {
    fun persist(person: Person):Person
}