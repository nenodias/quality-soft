package io.github.nenodias.qualitysoft.app.output.persistance.repository

import io.github.nenodias.qualitysoft.app.output.persistance.mapper.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<PersonEntity, Long>
