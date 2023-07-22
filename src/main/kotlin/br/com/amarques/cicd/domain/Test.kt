package br.com.amarques.cicd.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    name = "test",
    indexes = [Index(name = "idx_test_sort", columnList = "created_at DESC")]
)
data class Test(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "description", length = 150)
    var description: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime
)
