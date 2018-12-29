package com.app.item

import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ItemBootApplication

    fun main(args: Array<String>) {
        runApplication<ItemBootApplication>(*args)
        //SpringApplication.run(ItemBootApplication::class.java, *args)
    }

    @Bean
    internal fun modelMapper(): ModelMapper {
        return ModelMapper()
    }
