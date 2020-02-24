package com.example.spring.infra.configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaTopicConfiguration {

    @Bean
    fun messageTopic(@Value("\${spring.kafka.template.default-topic}") topic: String) = NewTopic(topic, 3, 1)

}