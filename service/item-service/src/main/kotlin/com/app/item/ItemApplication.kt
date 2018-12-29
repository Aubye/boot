package com.app.item

import org.modelmapper.ModelMapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ItemApplication {

    fun main(args: Array<String>) {
        SpringApplication.run(ItemApplication::class.java, *args)
    }

    @Bean
    internal fun modelMapper(): ModelMapper {
        return ModelMapper()
    }
}