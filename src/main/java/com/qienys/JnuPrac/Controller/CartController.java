package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.Cart;
import com.qienys.JnuPrac.pojo.Product;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.service.impl.CartServiceImpl;
import com.qienys.JnuPrac.service.impl.ProductPropertiesServiceImpl;
import com.qienys.JnuPrac.service.impl.ProductServiceImpl;
import com.qienys.JnuPrac.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@Controller
public class CartController {

    @Autowired
    private CartServiceImpl cartServiceImpl;
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductPropertiesServiceImpl productPropertiesServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(value = "/addToCart", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addToCart(@RequestBody JSONObject jsonParam) {
        //request productId  count
        Cart cart = JSON.parseObject(jsonParam.toJSONString(),Cart.class);
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        //User loginUser = userServiceImpl.findByUserName("user");//test
        cart.setUid(loginUser.getId());
        Product tempProduct = productServiceImpl.findById(cart.getProductId());
        cart.setBrandId(productPropertiesServiceImpl.
                findByBrandIdAndAndTypeId(tempProduct.getBrandId(),tempProduct.getTypeId()).getBrandId());
        cart.setTypeId(productPropertiesServiceImpl.
                findByBrandIdAndAndTypeId(tempProduct.getBrandId(),tempProduct.getTypeId()).getTypeId());
        //若购物车存在此商品则修改数量 不存在则保存新的数据
        if(cartServiceImpl.existsByUidAndProductId(loginUser.getId(),cart.getProductId())){
            Cart tempCart = cartServiceImpl.findByUidAndAndProductId(loginUser.getId(),cart.getProductId());
            tempCart.setCount(tempCart.getCount()+cart.getCount());
            cartServiceImpl.save(tempCart);
        }
        else{
            Product product = productServiceImpl.findById(cart.getProductId());
            cart.setProductName(product.getName());
            cart.setDescription(product.getDescription());
            cart.setUrl(product.getUrl());
            cart.setPrice(product.getPrice());
            cart.setActive(product.isActive());
            cartServiceImpl.save(cart);
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg","success");
        return jsonObject.toJSONString();
    }


    @RequestMapping(value = "/getCartList", method = RequestMethod.GET, produces = "application/json;charset = UTF-8")
    @ResponseBody
    public String getCartList(){
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();//test
        //User loginUser = userServiceImpl.findByUserName("user");

        List<Cart> cartList = cartServiceImpl.findAllByUid(loginUser.getId());
        JSON.toJSONString(cartList);
        //jsonArray.add(cartList);
        return JSON.toJSONString(cartList);
    }

    @PostMapping(value = "/changeCart", produces = "application/json;charset = UTF-8")
    @ResponseBody
    public String changeCart(@RequestBody JSONObject jsonParam){
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();//test
        //User loginUser = userServiceImpl.findByUserName("user");
        Cart cart = JSON.parseObject(jsonParam.toJSONString(),Cart.class);
        Cart tempCart = cartServiceImpl.findByUidAndAndProductId(loginUser.getId(),cart.getProductId());
        tempCart.setCount(tempCart.getCount()+cart.getCount());
        cartServiceImpl.save(tempCart);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("method", "json");
        jsonObject.put("msg","success");
        jsonObject.put("count",tempCart.getCount());
        return jsonObject.toJSONString();
    }

    @PostMapping(value = "/deleteFromCart", produces = "application/json;charset = UTF-8")
    @ResponseBody
    public String deleteFromCart(@RequestBody JSONObject jsonParam){
        //take productId
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        //User loginUser = userServiceImpl.findByUserName("user");//test
        Cart cart = JSON.parseObject(jsonParam.toJSONString(),Cart.class);
        cartServiceImpl.deleteByUidAndProductId(loginUser.getId(),cart.getProductId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","DeleteSuccess");
        jsonObject.put("router","MyCart");
        return jsonObject.toJSONString();
    }



    @GetMapping("getTotalPrice")
    @ResponseBody
    public String getTotalPrice(){
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        //User loginUser = userServiceImpl.findByUserName("user");
        JSONObject jsonObject = new JSONObject();
        String totalPrice = Double.toString((cal_totalPrice(loginUser.getId())));
        jsonObject.put("totalPrice",totalPrice);
        return jsonObject.toJSONString();
    }

    private double cal_totalPrice(Long uid) {
        int sum = 0;
        List<Cart> cartList = cartServiceImpl.findAllByUid(uid);
        for(Cart cart : cartList) {
            double price = productServiceImpl.findById(cart.getProductId()).getPrice() *cart.getCount();
            sum += price;
        }
        return sum;
    }
}
