package com.example.spring.infra.controller

import com.example.spring.domain.MessageService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/messages")
class MessageController(val messageService: MessageService) {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun post(@Validated @RequestBody request: MessageRequest) {
        messageService.send(request.message)
    }

}