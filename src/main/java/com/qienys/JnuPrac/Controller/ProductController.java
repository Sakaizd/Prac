package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.Product;
import com.qienys.JnuPrac.service.ProductService;
import com.qienys.JnuPrac.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    private static String UPLOADED_FOLDER = "src/main/resources/upload/";

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
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
            json.put("file name",file.getOriginalFilename().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json.toJSONString();
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @PostMapping(value = "/addProducts", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addProducts(@RequestBody JSONObject jsonParam){
        Product product = JSON.parseObject(jsonParam.toJSONString(),Product.class);
        productServiceImpl.save(product);
        return "";
    }


}
