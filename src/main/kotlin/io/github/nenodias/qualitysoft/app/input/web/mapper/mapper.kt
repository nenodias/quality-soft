package io.github.nenodias.qualitysoft.app.input.web.mapper

import io.github.nenodias.qualitysoft.core.domain.Person

fun PersonRequest.toDomain() = Person(
        id = id,
        name = name,
        profile = profile,
)