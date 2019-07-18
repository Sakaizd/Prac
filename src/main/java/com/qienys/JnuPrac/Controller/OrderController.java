package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.Cart;
import com.qienys.JnuPrac.pojo.OrderProducts;
import com.qienys.JnuPrac.pojo.Orders;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.service.impl.*;
import com.qienys.JnuPrac.util.snowflake;
import netscape.javascript.JSObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private OrdersServiceImpl ordersServiceImpl;
    @Autowired
    private OrderProductsServiceImpl orderProductsServiceImpl;
    @Autowired
    private CartServiceImpl cartServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private ProductServiceImpl productServiceImpl;




    @PostMapping(value = "/postCartList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String orderGen(@RequestBody JSONArray jsonParam){
        //telephone name address

        //订单号生产
        snowflake idWorker = new snowflake(0,0);
        Long orderId = idWorker.nextId();

        //User loginUser = userServiceImpl.findByUserName("user");//test
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();

        //index 0 传给orders表
        JSONObject orderInfo = jsonParam.getJSONObject(0) ;
        jsonParam.remove(0);

        JSONObject jsonObject = new JSONObject();

        if(!jsonParam.isEmpty()){
            List<Cart> cartList = JSON.parseArray(jsonParam.toJSONString(),Cart.class);

            //List<Cart> cartList = cartServiceImpl.findAllByUid(uid);

            for(Cart cart : cartList) {
                System.out.println("cart"+cart.getProductId()+" "+cart.getCount());
                Cart tempCart = cartServiceImpl.findByUidAndAndProductId(loginUser.getId(),cart.getProductId());
                System.out.println("tempcart"+tempCart.getProductId()+" "+tempCart.getCount());

                orderProductsServiceImpl.save(
                        new OrderProducts (
                                orderId,
                                cart.getProductId(),
                                tempCart.getProductName(),
                                tempCart.getDescription(),
                                cart.getCount(),
                                tempCart.getPrice()));

            }

            double sum = 0.0;
            for(Cart cart : cartList) {
                double price = productServiceImpl.findById(cart.getProductId()).getPrice() * cart.getCount();
                sum += price;
            }

            Orders order = JSON.parseObject(orderInfo.toJSONString(),Orders.class);
            order.setOrderId(orderId);
            order.setPayStatus(false);
            order.setPayStatus(false);
            order.setUid(loginUser.getId());
            order.setTotalPrice(sum);
            order.setCreateTime(new Date());
            ordersServiceImpl.save(order);


            jsonObject.put("router","");//去看订单
            jsonObject.put("msg","success");
        }
        else{
            jsonObject.put("router","");//去看订单
            jsonObject.put("msg","emptyList");
        }


        return jsonObject.toJSONString();
    }


    @ResponseBody
    @GetMapping(value = "/getOrderList")
    public String getOrderList(){
        //User loginUser = userServiceImpl.findByUserName("user");//test
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        List<Orders> ordersList= ordersServiceImpl.findAllByUid(loginUser.getId());
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("router","");
        jsonArray.add(json);
        jsonArray.add(ordersList);


        return jsonArray.toJSONString();
    }

    @ResponseBody
    @PostMapping(value = "/getOrderProducts", produces = "application/json;charset=UTF-8")
    public String getOrderProducts(@RequestBody JSONObject jsonParam){
        //User loginUser = userServiceImpl.findByUserName("user");//test
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        Orders orders= JSON.parseObject(jsonParam.toJSONString(),Orders.class);
        List<OrderProducts> orderProductsList= orderProductsServiceImpl.findAllByOrderId(orders.getOrderId());
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(orderProductsList);

        return jsonArray.toJSONString();
    }


    //admin api
    @ResponseBody
    @GetMapping(value = "/getAllOrders")
    public String getAllOrders(){

        //User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        List<Orders> ordersList= ordersServiceImpl.findAll();
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("router","");
        jsonArray.add(json);
        jsonArray.add(ordersList);

        return jsonArray.toJSONString();
    }


}
