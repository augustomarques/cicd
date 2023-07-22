package br.com.amarques.cicd.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class TestForm(

    @field:NotEmpty(message = "The [description] cannot be empty")
    @field:Size(max = 150, message = "The [description] must contain a maximum of [150] characters")
    val description: String

)