package com.qienys.JnuPrac.Controller;

import com.qienys.JnuPrac.service.impl.OrdersServiceImpl;
import com.qienys.JnuPrac.util.snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private OrdersServiceImpl ordersServiceImpl;

    @RequestMapping(value = "/orderGen", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String orderGen(){
        snowflake idWorker = new snowflake(0,0);
        Long orderId = idWorker.nextId();

        return "";
    }
}
