package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.Product;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.service.impl.ProductServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    private static String UPLOADED_FOLDER = "src/main/resources/static/upload/";

    @GetMapping("/static/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/static/upload") // //new annotation since 4.3
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        JSONObject json = new JSONObject();
        if (file.isEmpty()) {
            json.put("msg","empty file");
            return json.toJSONString();
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            json.put("msg","uploadSuccess");
            json.put("url",file.getOriginalFilename().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json.toJSONString();
    }


/*
    @GetMapping ("/addProducts")
    public String addProducts(){
        return "addProducts";
    }
*/

    //admin api
    @PostMapping(value = "/addProducts", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addProducts(@RequestBody JSONObject jsonParam){
        Product product = JSON.parseObject(jsonParam.toJSONString(),Product.class);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        JSONObject json = new JSONObject();
        //只有管理员有权限
        if(user.getUserType().equals("admin")){
            if(productServiceImpl.existsByTypeIdAndBrandIdAndName(
                    product.getTypeId(),
                    product.getBrandId(),
                    product.getName())) {
                json.put("msg","product already exist");
                json.put("router","");
            }else {
                productServiceImpl.save(product);
                json.put("msg","success");
                json.put("router","");
            }
        }
        else {
            json.put("msg","UnAuthentication")  ;
        }


        return json.toJSONString();
    }

    /*@PostMapping("/addProducts.action")
    @ResponseBody
    public String addProducts(Product product){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        JSONObject json = new JSONObject();
        //只有管理员有权限
        if(user.getUserType().equals("admin")){
            if(productServiceImpl.existsByTypeIdAndBrandIdAndName(
                    product.getTypeId(),
                    product.getBrandId(),
                    product.getName())) {
                json.put("msg","product already exist");
                json.put("router","");
            }else {
                productServiceImpl.save(product);
                json.put("msg","success");
                json.put("router","");
            }
        }
        else {
            json.put("msg","UnAuthentication")  ;
        }
        return json.toJSONString();
    }*/

    @PostMapping(value = "/changeProducts", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String changeProducts(@RequestBody JSONObject jsonParam){
        System.out.println(jsonParam.toJSONString());
        Product product = JSON.parseObject(jsonParam.toJSONString(),Product.class);
        JSONObject json = new JSONObject();
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        if(user.getUserType().equals("admin")) {
            /*Product tempProduct = productServiceImpl.
                    findByTypeIdAndBrandIdAndName(
                            product.getTypeId(),
                            product.getBrandId(),
                            product.getName());*/
            Product tempProduct = productServiceImpl.findById(product.getId());
            tempProduct.setBrandId(product.getBrandId());
            tempProduct.setActive(product.isActive());
            tempProduct.setUrl(product.getUrl());
            tempProduct.setTypeId(product.getTypeId());
            tempProduct.setStock(product.getStock());
            tempProduct.setSold(product.getSold());
            tempProduct.setPrice(product.getPrice());
            tempProduct.setName(product.getName());
            tempProduct.setDescription(product.getDescription());
                productServiceImpl.save(tempProduct);
                json.put("msg", "changeSuccess");
                json.put("router","");
            }

        else {
            json.put("msg","UnAuthentication")  ;
            json.put("router","");
        }
        return  json.toJSONString();
    }


}
