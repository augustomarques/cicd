package br.com.amarques.cicd.service

import br.com.amarques.cicd.dto.TestForm
import br.com.amarques.cicd.dto.TestView
import br.com.amarques.cicd.mapper.TestMapper.Companion.mapToDomain
import br.com.amarques.cicd.mapper.TestMapper.Companion.mapToView
import br.com.amarques.cicd.repository.TestRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class TestService(private val testRepository: TestRepository) {

    @Transactional
    fun create(testForm: TestForm): TestView {
        val test = mapToDomain(testForm)
        testRepository.save(test)
        return mapToView(test)
    }

    fun getAll(): List<TestView> {
        return testRepository.findAll().map { mapToView(it) }
    }
}