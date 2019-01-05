package com.app.index.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/index")
public class IndexController {

    @GetMapping
    @ResponseBody
    public String index(){
        return "Hello World";
    }

}
