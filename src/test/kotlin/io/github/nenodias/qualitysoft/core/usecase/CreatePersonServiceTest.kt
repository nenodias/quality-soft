package io.github.nenodias.qualitysoft.core.usecase

import io.github.nenodias.qualitysoft.core.domain.Person
import io.github.nenodias.qualitysoft.core.ports.output.PersistPersonPortOut
import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.*
import java.lang.RuntimeException
import kotlin.reflect.typeOf

class CreatePersonServiceTest {

    private lateinit var repository: PersistPersonPortOut
    private lateinit var usecase: CreatePersonService

    @BeforeEach
    fun setup() {
        this.repository = mockk()
        every { repository.persist(any()) } answers { firstArg() }
        this.usecase = CreatePersonService(repository)
    }

    @Test
    fun `should create a person`() {
        val person = Person(null,"Brock Harrison", "Gym Leader")
        val actual = this.usecase.createPerson(person)
        assert(actual == person)
    }

    @Test
    fun `my first test`(){
        val myMock = mockk<File>()
        every { myMock.canRead() } returns true
        every { myMock.canWrite() } answers { false }
        every { myMock.deleteOnExit() } just runs
        every { myMock.exists() } throws FileNotFoundException("File not found")

        myMock.deleteOnExit()
        myMock.canRead()
        myMock.canWrite()

        verify {
            myMock.canWrite()
            myMock.canRead()
        }
        var ex: Exception? = null
        try {
            myMock.exists()
        } catch (e: FileNotFoundException) {
            ex = e
        }
        assert(FileNotFoundException::class.isInstance(ex))
    }

}
