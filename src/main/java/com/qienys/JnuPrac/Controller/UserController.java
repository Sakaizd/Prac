package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.pojo.UserInfo;
import com.qienys.JnuPrac.service.impl.UserInfoServiceImpl;
import com.qienys.JnuPrac.service.impl.UserServiceImpl;
import com.qienys.JnuPrac.util.MD5Utils;
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

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String postUserInfo(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam.toJSONString());
        JSONObject jsonUser = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        User user = JSON.parseObject(jsonParam.toJSONString(),User.class);
        User loginUser = userServiceImpl.findByUserName(user.getUserName());
        System.out.println(loginUser.getUserName());
        UserInfo userInfo = userInfoServiceImpl.findByUid(loginUser.getId());
        jsonUser.put("router", "/QueryUserInfo");
        jsonUser.put("method", "json");
        jsonUser.put("username", user.getUserName());
        jsonUser.put("userType", user.getUserType());
        //先放jsonUser
        jsonArray.add(jsonUser);
        jsonArray.add(userInfo);
        System.out.println(jsonArray.toJSONString());
        return jsonArray.toJSONString();
    }


    @RequestMapping(value = "/passwdModify", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passwdModify(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam.toJSONString());
        JSONObject result = new JSONObject();
        //传入数据 username password
        User user = JSON.parseObject(jsonParam.toJSONString(),User.class);
        System.out.println(user.getUserName()+"  "+user.getPassword());
        //修改密码 保存
        User loginUser = userServiceImpl.findByUserName(user.getUserName());
        String password = MD5Utils.encrypt(user.getUserName(), user.getPassword());
        loginUser.setPassword(password);
        userServiceImpl.save(loginUser);

        UserInfo userInfo = userInfoServiceImpl.findByUid(loginUser.getId());
        String Info = JSON.toJSONString(userInfo);
        result.put("router", "/QueryDataPage/:username");
        result.put("method", "json");

        result.put("userInfo", Info);
        result.put("msg","ModifySuccess");
        result.put("username", user.getUserName());
        result.put("userType", user.getUserType());

        return result.toJSONString();
    }


    @RequestMapping("/jsontest")
    @ResponseBody
    public String getTest(){
        JSONObject jsonUser = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        User loginUser = userServiceImpl.findByUserName("user");
        System.out.println(loginUser.getUserName());
        UserInfo userInfo = userInfoServiceImpl.findByUid(loginUser.getId());
        jsonUser.put("router", "/");
        jsonUser.put("method", "json");
        jsonUser.put("username", loginUser.getUserName());
        jsonUser.put("usertype", loginUser.getUserType());

        jsonArray.add(jsonUser);
        jsonArray.add(userInfo);
        return jsonArray.toJSONString();
    }



}
