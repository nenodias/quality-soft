package io.github.nenodias.qualitysoft.app.output.persistance.mapper

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table
class PersonEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false) val id: Long?,
        @Column(nullable = false, length = 255) val name: String,
        @Column(nullable = false, length = 10) val profile: String) : Serializable {

}