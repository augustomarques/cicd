package br.com.amarques.cicd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CicdApplication

fun main(args: Array<String>) {
	runApplication<CicdApplication>(*args)
}
