package com.example.apacheavro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableSchemaRegistryClient
@EnableScheduling
class ApacheAvroApplication

fun main(args: Array<String>) {
	runApplication<ApacheAvroApplication>(*args)
}
