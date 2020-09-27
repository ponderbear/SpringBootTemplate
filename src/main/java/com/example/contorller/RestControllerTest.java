package com.example.contorller;

import com.example.entity.Order;
import com.example.entity.User;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
//由Controller和ResponseBody组成，返回data 而不是 View
@RequestMapping("/order")
public class RestControllerTest {

    //1、value和path：在源码层级互为引用，所以是等价的
    //@RequestMapping(value = "/{id}")

    @RequestMapping(path = "/{id}")
    public String getCertainOrder(@PathVariable("id") String id) {
        return id;
    }

    //2、@Pathvariable占位符：java8能根据url请求的路径名，名称的自动匹配
    //mime：mutipurpose internet mail extendsions；applicaionn :binary type/subType
    @RequestMapping(path = "/{orderId}/user/{userId}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public User getOrderUser(@PathVariable String orderId, @PathVariable String userId){
        String userName = "john";
        User oneUser = new User(orderId ,userName, userId);
        return oneUser;
    }

    //3、@RequestParam解析body参数：根据url拼接的参数，body里（get后带==post body里）,value：key，dv：没有则填写的默认值
    @RequestMapping (value = "/{orderId}/user")
    public User getOrderUserName(@PathVariable String orderId, @RequestParam(value = "userId", required = true, defaultValue = "2020") String userId){
        System.out.println(orderId);
        User user = new User("Dick","22", userId);
        return user;

    }

    //4、@RequestBody：通过requestBody将body为json格式的数据解析为javabean（通过jackson）
    @RequestMapping(value = "/userOrder", method = RequestMethod.POST)
    public Order addUserOrder(@RequestBody Order order){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd: hh : mm");
        String formatString = simpleDateFormat.format(date);
        order.setOrderTime(date);
        System.out.println(order.toString());
        return order;

    }

    //4、Modle或ModelView：httpxmlRequest方法自带Model对象，注入后，前端再获取

    //5、JavaBean根据拼接参数解析：参数对应接收对象的属性，则可以自动接收为javaBean


}
