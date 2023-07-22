package br.com.amarques.cicd.repository

import br.com.amarques.cicd.domain.Test
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : JpaRepository<Test, Long> {
}