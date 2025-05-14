package com.example.worder.config

import com.example.worder.starter.Application
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class WorderConfig {
    @Bean
    fun worderApplication() = Application()
}
