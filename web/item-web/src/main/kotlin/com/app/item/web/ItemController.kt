package com.app.item.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/item")
class ItemController {

    @GetMapping
    fun getList(model: Model): String {
        model["title"] = "Spring Boot"
        return "index"
    }

}