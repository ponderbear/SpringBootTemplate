package com.example.contorller;

import com.example.entity.Order;
import com.example.entity.User;
import com.example.service.UserOrderService;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//使用lombok，采用slf4j注解，可以不用频繁创建logger，默认直接只用log来输出logback日志
@Slf4j
@RestController
//由Controller和ResponseBody组成，返回data 而不是 View
@RequestMapping("/order")
public class RestControllerTest {
//    Logger logger = LoggerFactory.getLogger(RestControllerTest.class);

    @Resource
//    若接口的实现类有多个，则需添加名称实现类名称+接口类定义（或者只写实现类定义）；若实现类只有一个，则可以用接口定义，也不用声明实现类名称
    private UserOrderService userOrderService;

    @Autowired
    private UserService userService;

    //1、value和path：在源码层级互为引用，所以是等价的
    //@RequestMapping(value = "/{id}")

    @RequestMapping(path = "/{id}")
    public String getCertainOrder(@PathVariable("id") String id) {
        log.error("获取订单编号！！！");
        log.warn("获取订单编号！！！");
        log.info("获取订单编号！！！");
        log.debug("获取订单编号！！！");
        log.trace("获取订单编号！！！");
        return id;
    }

    //2、@Pathvariable占位符：java8能根据url请求的路径名，名称的自动匹配
    //mime：mutipurpose internet mail extendsions；applicaionn :binary type/subType
    @RequestMapping(path = "/{orderId}/user/{userId}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public User getOrderUser(@PathVariable String orderId, @PathVariable Integer userId){
        String userName = "john";
        User oneUser = new User(orderId ,userName, userId);
        log.error("获取订单用户！！！");
        log.warn("获取订单用户！！！");
        log.info("获取订单用户！！！");
        log.debug("获取订单用户！！！");
        log.trace("获取订单用户！！！");
        return oneUser;
    }

    //3、@RequestParam解析body参数：根据url拼接的参数，body里（get后带==post body里）,value：key，dv：没有则填写的默认值
    @RequestMapping (value = "/{orderId}/user")
    public User getOrderUserName(@PathVariable String orderId, @RequestParam(value = "userId", required = true, defaultValue = "2020") Integer userId){
        System.out.println(orderId);
        User user = new User("Dick","22", userId);
        log.error("获取订单用户名称！！！");
        log.warn("获取订单用户名称！！！");
        log.info("获取订单用户名称！！！");
        log.debug("获取订单用户名称！！！");
        log.trace("获取订单用户名称！！！");
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

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Long addUser(@RequestBody User user){
        Long userKey = userService.addUser(user);
        return userKey;
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public List<User> getUser(@PathVariable("userName") String userName){
        log.info("查找用户名称！！");
        return userService.getUserByName(userName);
    }

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.POST)
    public Integer deleteUser(@PathVariable("userId") Integer userId){
        log.info("删除用户");
        return userService.deleteUser(userId);
    }

    //4、Modle或ModelView：httpxmlRequest方法自带Model对象，注入后，前端再获取

    //5、JavaBean根据拼接参数解析：参数对应接收对象的属性，则可以自动接收为javaBean


    @RequestMapping(value = "/user/{userId}/order/{orderId}",method = RequestMethod.GET)
    public List<Order> getUserOrder(@PathVariable Integer userId, @PathVariable Integer  orderId ){
        List<Order> orderList = userOrderService.getUserOrder(userId, orderId);
        return orderList;
    }

    @RequestMapping(value = "/user/{userId}/order",method = RequestMethod.GET)
    public List<Order> getUserAllOrder(@PathVariable("userId") Integer userId,@RequestParam(value = "timeStamp",required = false, defaultValue = "2020" )String timeStamp){
        List<Order> userOrderList = userOrderService.getUserAllOrder(userId);
        return userOrderList;
    }

    @RequestMapping(value = "/userPar", method = RequestMethod.GET)
    public List<Order> getPartialUserOrder(@RequestBody List<String> userList){
        return userOrderService.getPartialUserOrder(userList);
    }

    @RequestMapping(value = "/associatedUser/{userId}", method = RequestMethod.GET)
    public User getAssociatedUser(@PathVariable("userId")Integer userId){
        return userService.getUser(userId);
    }


    @ModelAttribute
    public void firstVisit(){
        System.out.println("所有的controller请求会首先调用ModelAttribute注解方法");
        log.error("第一次访问！！！");
        log.warn("第一次访问！！！");
        log.info("第一次访问！！！");
        log.debug("第一次访问！！！");
        log.trace("第一次访问！！！");
    }
}
