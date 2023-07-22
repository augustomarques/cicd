package br.com.amarques.cicd.dto

import java.time.LocalDateTime

data class TestView(

    val id: Long?,

    var description: String,

    val createdAt: LocalDateTime
)