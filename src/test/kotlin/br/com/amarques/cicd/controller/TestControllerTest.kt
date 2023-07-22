package br.com.amarques.cicd.controller

import br.com.amarques.cicd.dto.TestForm
import br.com.amarques.cicd.dto.TestView
import br.com.amarques.cicd.service.TestService
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import net.datafaker.Faker
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.time.LocalDateTime

@WebMvcTest(controllers = [TestController::class])
class TestControllerTest {

    companion object {
        const val RESOURCE = "/tests"
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockkBean
    private lateinit var testService: TestService

    private lateinit var faker: Faker

    @BeforeEach
    fun setup() {
        faker = Faker()
    }

    @Test
    fun `should make a request and create a new customer`() {
        val randomText = faker.text().text(1, 150)
        val testForm = TestForm(
            description = randomText
        )

        val testView = TestView(
            id = faker.number().randomNumber(),
            description = randomText,
            createdAt = LocalDateTime.now()
        )

        every { testService.create(testForm) } returns testView

        mockMvc.post(RESOURCE) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(testForm)
        }.andExpect {
            status { isCreated() }
            content { contentType(MediaType.APPLICATION_JSON) }

            jsonPath("$.id") { value(testView.id) }
            jsonPath("$.description") { value(testView.description) }
            jsonPath("$.createdAt") { value(testView.createdAt.toString()) }
        }
    }
}