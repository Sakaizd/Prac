package com.qienys.JnuPrac.Controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.Product;
import com.qienys.JnuPrac.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MallController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/getAllProducts")
    @ResponseBody
    public String showItem(){
        JSONArray Products = new JSONArray();
        JSONObject json = new JSONObject();
        List<Product> ProductList = productServiceImpl.findAll();
        Products.add(json);
        Products.add(ProductList);
        return Products.toJSONString();
    }


}
