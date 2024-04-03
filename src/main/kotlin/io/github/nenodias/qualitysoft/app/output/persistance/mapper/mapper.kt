package io.github.nenodias.qualitysoft.app.output.persistance.mapper

import io.github.nenodias.qualitysoft.core.domain.Person

fun Person.toEntity() = PersonEntity(
        id = id,
        name = name,
        profile = profile
)

fun PersonEntity.toDomain() = Person(
        id = id,
        name = name,
        profile = profile
)