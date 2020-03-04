package com.example.apacheavro.domain

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService(val kafkaTemplate: KafkaTemplate<String, Employee>) {

    private final val log = LoggerFactory.getLogger(this::class.java)

    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
    fun producer() {
        log.info("Generating random data")
        val employee = Employee()
        employee.setId(Random().nextInt())
        employee.setFirstName(UUID.randomUUID().toString())
        employee.setLastName(UUID.randomUUID().toString())

        kafkaTemplate.sendDefault(employee)
        log.info("Generated random data")
    }

    @KafkaListener(topics = ["\${spring.kafka.template.default-topic}"])
    fun consumer(record: ConsumerRecord<String, Employee>) {
        log.info("Consuming $record")
        log.info("Consumed $record")
    }

}