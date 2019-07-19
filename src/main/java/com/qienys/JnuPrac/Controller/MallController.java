package com.qienys.JnuPrac.Controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.Product;
import com.qienys.JnuPrac.service.impl.ProductPropertiesServiceImpl;
import com.qienys.JnuPrac.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MallController {

    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductPropertiesServiceImpl productPropertiesServiceImpl;

    @GetMapping("/getAllProducts")
    @ResponseBody
    public String showItem(){
        JSONArray jsonArray = new JSONArray();
        //JSONObject json = new JSONObject();
        List<Product> productList = productServiceImpl.findAll();
        //jsonArray.add(productList);
        int i=1;
        for(Product product : productList) {
            System.out.println(i++);
            JSONObject json = new JSONObject();
            json.put("brandName",productPropertiesServiceImpl.
                    findByBrandIdAndAndTypeId(product.getBrandId(),product.getTypeId()).getBrandName());
            json.put("typeName",productPropertiesServiceImpl.
                    findByBrandIdAndAndTypeId(product.getBrandId(),product.getTypeId()).getTypeName());
            json.put("id",product.getId());
            json.put("price",product.getPrice());
            json.put("name",product.getName());
            json.put("typeId",product.getTypeId());
            json.put("brandId",product.getBrandId());
            json.put("description",product.getDescription());
            json.put("sold",product.getSold());
            json.put("stock",product.getStock());
            json.put("active",product.isActive());
            json.put("url",product.getUrl());
            jsonArray.add(json);
        }
        //System.out.println(jsonArray.toJSONString());
        return jsonArray.toJSONString();
    }


}
