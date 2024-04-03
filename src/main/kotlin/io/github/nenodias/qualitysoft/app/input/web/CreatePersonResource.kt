package io.github.nenodias.qualitysoft.app.input.web

import io.github.nenodias.qualitysoft.app.input.web.mapper.PersonRequest
import io.github.nenodias.qualitysoft.app.input.web.mapper.toDomain
import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.input.CreatePersonPortIn
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class CreatePersonResource(private val useCase: CreatePersonPortIn) {

    @PostMapping
    fun createPerson(@RequestBody request: PersonRequest) = useCase.createPerson(request.toDomain())

}