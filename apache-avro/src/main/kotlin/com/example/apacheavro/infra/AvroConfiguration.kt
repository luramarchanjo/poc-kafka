package com.example.apacheavro.infra

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AvroConfiguration {

    @Bean
    fun schemaRegistryClient(@Value("\${spring.cloud.stream.schemaRegistryClient.endpoint}") endpoint: String): SchemaRegistryClient {
        val client = ConfluentSchemaRegistryClient()
        client.setEndpoint(endpoint)

        return client
    }

}