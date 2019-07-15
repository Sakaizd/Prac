package com.qienys.JnuPrac.Controller;

import com.qienys.JnuPrac.util.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pswGen {
    @RequestMapping("/pswgen")
    public String pswgen(){
        String username = "user";
        String password = "123";
        password = MD5Utils.encrypt(username,password);
        return password;
    }
}
