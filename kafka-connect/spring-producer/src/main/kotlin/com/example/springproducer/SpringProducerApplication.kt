package com.example.springproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringProducerApplication

fun main(args: Array<String>) {
	runApplication<SpringProducerApplication>(*args)
}
