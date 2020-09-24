package com.example.contorller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//由Controller和ResponseBody组成，返回data 而不是 View
public class RestControllerTest {
    @RequestMapping(value = "/journey/{id}")
    public String getGo(@PathVariable("id") String id) {
        return id;
    }


}
