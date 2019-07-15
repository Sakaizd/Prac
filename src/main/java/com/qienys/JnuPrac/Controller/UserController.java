package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.pojo.UserInfo;
import com.qienys.JnuPrac.service.impl.UserInfoServiceImpl;
import com.qienys.JnuPrac.service.impl.UserServiceImpl;
import com.qienys.JnuPrac.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    @Autowired
    private UserInfoServiceImpl userInfoServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getUserInfo(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam.toJSONString());
        JSONObject result = new JSONObject();
        User user = JSON.parseObject(jsonParam.toJSONString(),User.class);
        User loginUser = userServiceImpl.findByUserName(user.getUserName());
        System.out.println(loginUser.getUserName());
        UserInfo userInfo = userInfoServiceImpl.findByUid(loginUser.getId());
        result.put("router", "LoginSuccess");
        result.put("method", "json");
        result.put("data",userInfo);
        result.put("username", user.getUserName());
        result.put("usertype", user.getUserType());

        return result.toJSONString();
    }

    @RequestMapping("/jsontest")
    @ResponseBody
    public String getTest(){

        JSONObject result = new JSONObject();
        User loginUser = userServiceImpl.findByUserName("user");
        System.out.println(loginUser.getUserName());
        UserInfo userInfo = userInfoServiceImpl.findByUid(loginUser.getId());
        System.out.println(userInfo.getAddress());
        String data = JSON.toJSONString(userInfo);
        result.put("router", "LoginSuccess");
        result.put("method", "json");
        result.put("data",data);
        result.put("username", loginUser.getUserName());
        result.put("usertype", loginUser.getUserType());
        System.out.println(result.toJSONString());
        return result.toJSONString();
    }
}
