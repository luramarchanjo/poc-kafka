package com.example.apacheavro

import com.example.apacheavro.domain.EmployeeV2
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService(val kafkaTemplate: KafkaTemplate<String, EmployeeV2>) {

    private final val log = LoggerFactory.getLogger(this::class.java)

    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
    fun producer() {
        log.info("Generating random data")
        val employee = EmployeeV2()
        employee.setId(Random().nextInt())
        employee.setName(UUID.randomUUID().toString())

        kafkaTemplate.sendDefault(employee)
    }

}