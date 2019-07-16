package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.Product;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.service.ProductService;
import com.qienys.JnuPrac.service.impl.ProductServiceImpl;
import com.qienys.JnuPrac.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MallController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/getAllProducts")
    @ResponseBody
    public String showItem(){
        JSONArray Products = new JSONArray();
        List<Product> ProductList = productServiceImpl.findAll();
        Products.add(ProductList);
        return Products.toJSONString();

    }

}
