package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class ProductController {

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



}
