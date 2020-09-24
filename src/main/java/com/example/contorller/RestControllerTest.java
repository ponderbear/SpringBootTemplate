package com.example.contorller;

import com.example.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
//由Controller和ResponseBody组成，返回data 而不是 View
@RequestMapping("/order")
public class RestControllerTest {

    //value和path在源码层级互为引用，所以是等价的
    //@RequestMapping(value = "/{id}")
    @RequestMapping(path = "/{id}")
    public String getCertainOrder(@PathVariable("id") String id) {
        return id;
    }
    //java8能根据url请求的路径名，名称的自动匹配
    @RequestMapping(path = "/{orderId}/user/{userId}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public User getOrderUser(@PathVariable String orderId, @PathVariable String userId){
        User oneUser = new User(orderId , userId);
        return oneUser;

    }
}
