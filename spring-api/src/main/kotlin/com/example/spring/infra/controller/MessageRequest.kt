package com.example.spring.infra.controller

import javax.validation.constraints.NotBlank

data class MessageRequest(@NotBlank val message: String)