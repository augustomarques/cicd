package br.com.amarques.cicd.domain

import net.datafaker.Faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TestTest {

    private lateinit var faker: Faker

    @BeforeEach
    fun setup() {
        faker = Faker()
    }

    @Test
    fun `should generate a test`() {
        val randomText = faker.text().text(1, 150)

        val test = br.com.amarques.cicd.domain.Test(
            description = randomText,
            createdAt = LocalDateTime.now()
        )

        assertThat(test).isNotNull
        assertThat(test.id).isNull()
        assertThat(test.description).isEqualTo(randomText)
        assertThat(test.createdAt).isBefore(LocalDateTime.now())
    }
}