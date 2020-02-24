package com.example.spring.domain

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MessageService(val kafkaTemplate: KafkaTemplate<String, String>) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun send(message: String) {
        log.info("Sending Message=[$message] to Topic=[${kafkaTemplate.defaultTopic}]")
        kafkaTemplate.sendDefault(message)
        log.info("Sent Message=[$message] to Topic=[${kafkaTemplate.defaultTopic}]")
    }

    @KafkaListener(topics = ["\${spring.kafka.template.default-topic}"])
    fun process(message: String) {
        log.info("Consuming Message=[$message] Topic=[${kafkaTemplate.defaultTopic}]")
        // Some business logic
        log.info("Consumed Message=[$message] Topic=[${kafkaTemplate.defaultTopic}]")
    }

}