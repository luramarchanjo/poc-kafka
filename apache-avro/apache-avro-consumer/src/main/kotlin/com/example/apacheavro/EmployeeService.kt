package com.example.apacheavro

import com.example.apacheavro.domain.Employee
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class EmployeeService() {

    private final val log = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = ["\${spring.kafka.template.default-topic}"])
    fun consumer(record: ConsumerRecord<String, Employee>) {
        log.info("Consuming $record")
    }

}