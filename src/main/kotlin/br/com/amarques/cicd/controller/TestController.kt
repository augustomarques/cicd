package br.com.amarques.cicd.controller

import br.com.amarques.cicd.dto.TestForm
import br.com.amarques.cicd.dto.TestView
import br.com.amarques.cicd.service.TestService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@Tag(name = "Tests")
@RestController
@RequestMapping("/tests")
class TestController(private val testService: TestService) {

    var logger: Logger = LoggerFactory.getLogger(TestController::class.java)

    @PostMapping
    @Operation(summary = "Register a new Test")
    fun create(@RequestBody @Valid testForm: TestForm, uriComponentsBuilder: UriComponentsBuilder)
            : ResponseEntity<TestView> {
        logger.info("REST request - creating a new test $testForm")

        val testView = testService.create(testForm)
        val uri = uriComponentsBuilder.path("/tests/${testView.id}").build().toUri()

        return ResponseEntity.created(uri).body(testView)
    }

    @GetMapping
    @Operation(summary = "Search for registered tests")
    fun getAll(): List<TestView> {
        logger.info("REST request - Searching all tests")

        return testService.getAll()
    }
}