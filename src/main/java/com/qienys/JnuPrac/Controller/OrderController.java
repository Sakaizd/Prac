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



    @PostMapping(value = "/orderGen", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String orderGen(@RequestBody JSONArray jsonParam){
        //telephone name address Cartlist

        //订单号生成
        snowflake idWorker = new snowflake(0,0);
        Long orderId = idWorker.nextId();

            // User loginUser = userServiceImpl.findByUserName("user");//test
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();

        //index 0 传给orders表
        JSONObject orderInfo = jsonParam.getJSONObject(0) ;
        jsonParam.remove(0);

        JSONObject jsonObject = new JSONObject();

        if(!jsonParam.isEmpty()){
            List<Cart> cartList = JSON.parseArray(jsonParam.toJSONString(),Cart.class);
            for(Cart cart : cartList) {
                //System.out.println("cart pid"+cart.getProductId()+" count"+cart.getCount());
                Cart tempCart = cartServiceImpl.findByUidAndAndProductId(loginUser.getId(),cart.getProductId());
                //System.out.println("tempcart pid"+tempCart.getProductId()+" count"+tempCart.getCount());
                orderProductsServiceImpl.save(
                        new OrderProducts (
                                orderId,
                                cart.getProductId(),
                                tempCart.getProductName(),
                                tempCart.getDescription(),
                                cart.getCount(),
                                tempCart.getPrice()));
                cartServiceImpl.deleteByUidAndProductId(loginUser.getId(),cart.getProductId());

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


            jsonObject.put("router","myOrders");//去看订单
            jsonObject.put("msg","success");
        }
        else{
            jsonObject.put("router","default");//去看订单
            jsonObject.put("msg","emptyList");
        }


        return jsonObject.toJSONString();
    }



    //获取用户的所有订单
    @ResponseBody
    @GetMapping(value = "/getUserOrders")
    public String getUserOrders(){
        //User loginUser = userServiceImpl.findByUserName("user");//test
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(loginUser.getUserName());
        List<Orders> ordersList= ordersServiceImpl.findAllByUid(loginUser.getId());
        JSONArray jsonArray = new JSONArray();
        for(Orders orders:ordersList){
            JSONObject json = new JSONObject();
            json.put("address",orders.getAddress());
            json.put("name",orders.getName());
            json.put("orderId",orders.getOrderId().toString());
            json.put("payStatus",orders.isPayStatus());
            json.put("postStatus",orders.isPostStatus());
            json.put("telephone",orders.getTelephone());
            json.put("totalPrice",orders.getTotalPrice());
            //System.out.println(orders.getCreateTime());
            String createTime= JSON.toJSONStringWithDateFormat
                    (orders.getCreateTime(), "yyyy-MM-dd HH:mm:ss").
                    replace("\"", "");
            //System.out.println(JSON.toJSONStringWithDateFormat(orders.getCreateTime(), "yyyy-MM-dd HH:mm:ss:S"));
            json.put("createTime",createTime);
            jsonArray.add(json);
        }
        return JSON.toJSONString(jsonArray);
    }

    //根据订单号查商品
    @ResponseBody
    @PostMapping(value = "/getOrderProducts", produces = "application/json;charset=UTF-8")
    public String getOrderProducts(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam);
        //request orderId
        //User loginUser = userServiceImpl.findByUserName("user");//test
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        Orders tempOrder= JSON.parseObject(jsonParam.toJSONString(),Orders.class);
        Orders orders=ordersServiceImpl.findByOrderId(tempOrder.getOrderId());
        JSONArray jsonArray = new JSONArray();
        if(ordersServiceImpl.existsByOrderId(orders.getOrderId())&&
        orders.getUid().equals(loginUser.getId())){
            List<OrderProducts> orderProductsList= orderProductsServiceImpl.findAllByOrderId(orders.getOrderId());
            for(OrderProducts orderProducts:orderProductsList){
                JSONObject json = new JSONObject();
                json.put("count",orderProducts.getCount());
                json.put("description",orderProducts.getDescription());
                json.put("orderId",orderProducts.getOrderId().toString());
                json.put("price",orderProducts.getPrice());
                json.put("productId",orderProducts.getProductId());
                json.put("productName",orderProducts.getProductName());
                json.put("payStatus",orders.isPayStatus());
                json.put("postStatus",orders.isPostStatus());
                jsonArray.add(json);
            }
            return JSON.toJSONString(jsonArray);
        }
        else{
            JSONObject json = new JSONObject();
            json.put("msg","Wrong OrderId");
            return json.toJSONString();
        }
    }


    //admin api
    @ResponseBody
    @GetMapping(value = "/getAllOrders")
    public String getAllOrders(){
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user.getUserName());
        if(SecurityUtils.getSubject().isAuthenticated()&&loginUser.getUserType().equals("admin")){
            List<Orders> ordersList = ordersServiceImpl.findAll();
            JSONArray jsonArray = new JSONArray();
            for(Orders orders:ordersList){
                JSONObject json = new JSONObject();
                json.put("address",orders.getAddress());
                json.put("name",orders.getName());
                json.put("orderId",orders.getOrderId().toString());
                json.put("payStatus",orders.isPayStatus());
                json.put("postStatus",orders.isPostStatus());
                json.put("telephone",orders.getTelephone());
                json.put("totalPrice",orders.getTotalPrice());
                //System.out.println(orders.getCreateTime());
                String createTime= JSON.toJSONStringWithDateFormat
                        (orders.getCreateTime(), "yyyy-MM-dd HH:mm:ss").
                        replace("\"", "");
                //System.out.println(JSON.toJSONStringWithDateFormat(orders.getCreateTime(), "yyyy-MM-dd HH:mm:ss:S"));
                json.put("createTime",createTime);
                jsonArray.add(json);
            }
                return jsonArray.toJSONString();
            }
        else {
            JSONObject json = new JSONObject();
            json.put("msg","UnAuthorization");
            json.put("router","");
            return json.toJSONString();
        }

    }

    @ResponseBody
    @PostMapping(value = "/getOrderProductsByAdmin", produces = "application/json;charset=UTF-8")
    public String getOrderProductsByAdmin(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam);
        //request orderId
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        Orders tempOrder= JSON.parseObject(jsonParam.toJSONString(),Orders.class);
        Orders orders=ordersServiceImpl.findByOrderId(tempOrder.getOrderId());
        JSONArray jsonArray = new JSONArray();
        if(ordersServiceImpl.existsByOrderId(orders.getOrderId())&&
                loginUser.getUserType().equals("admin")){
            List<OrderProducts> orderProductsList= orderProductsServiceImpl.findAllByOrderId(orders.getOrderId());
            for(OrderProducts orderProducts:orderProductsList){
                JSONObject json = new JSONObject();
                json.put("count",orderProducts.getCount());
                json.put("description",orderProducts.getDescription());
                json.put("orderId",orderProducts.getOrderId().toString());
                json.put("price",orderProducts.getPrice());
                json.put("productId",orderProducts.getProductId());
                json.put("productName",orderProducts.getProductName());
                json.put("payStatus",orders.isPayStatus());
                json.put("postStatus",orders.isPostStatus());
                jsonArray.add(json);
            }
            return JSON.toJSONString(jsonArray);
        }
        else{
            JSONObject json = new JSONObject();
            json.put("msg","UnAuthentication")  ;
            json.put("router","");
            return json.toJSONString();
        }
    }

    //模拟支付
    @ResponseBody
    @PostMapping(value = "/setOrderPay", produces = "application/json;charset=UTF-8")
    public String setOrderPay(@RequestBody JSONObject JsonParam){
        //request orderId
        System.out.println(JsonParam);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Orders orders = JSON.parseObject(JsonParam.toJSONString(),Orders.class);
        Orders tempOrder = ordersServiceImpl.findByOrderId(orders.getOrderId());
        tempOrder.setPayStatus(true);
        ordersServiceImpl.save(tempOrder);
        JSONObject json = new JSONObject();
        json.put("msg","success");
        json.put("router","");
        return json.toJSONString();
    }



    //admin api
    //后台设置发货
    @ResponseBody
    @PostMapping(value = "/setOrderPost", produces = "application/json;charset=UTF-8")
    public String setOrderPost(@RequestBody JSONObject JsonParam){
        //request orderId
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        JSONObject json = new JSONObject();
        //只有管理员有权限
        if(user.getUserType().equals("admin")){
            Orders orders = JSON.parseObject(JsonParam.toJSONString(),Orders.class);
            Orders tempOrder = ordersServiceImpl.findByOrderId(orders.getOrderId());
            tempOrder.setPostStatus(true);
            ordersServiceImpl.save(tempOrder);

            json.put("msg","success");
            json.put("router","");
        }
        else {
            json.put("msg","UnAuthentication")  ;
            json.put("router","");
        }

        return json.toJSONString();
    }

}
