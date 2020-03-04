package com.example.apacheavro.domain

import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.schema.SchemaReference
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class EmployeeService(val schemaRegistryClient: SchemaRegistryClient) {

    private final val log = LoggerFactory.getLogger(this::class.java)

    @Scheduled(initialDelay = 1000, fixedDelay = 60000)
    fun fetchSchema() {
        val schemaReference = SchemaReference("customer-schema", 1, "application/json")
        val schema = schemaRegistryClient.fetch(schemaReference)
        log.info(schema)
    }

}