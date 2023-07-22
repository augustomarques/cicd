package br.com.amarques.cicd.mapper

import br.com.amarques.cicd.domain.Test
import br.com.amarques.cicd.dto.TestForm
import br.com.amarques.cicd.dto.TestView
import java.time.LocalDateTime

class TestMapper {

    companion object {
        fun mapToDomain(testForm: TestForm): Test {
            return Test(
                description = testForm.description,
                createdAt = LocalDateTime.now()
            )
        }

        fun mapToView(test: Test): TestView {
            return TestView(
                id = test.id,
                description = test.description,
                createdAt = test.createdAt
            )
        }
    }
}