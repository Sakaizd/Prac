package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.service.impl.UserServiceImpl;
import com.qienys.JnuPrac.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody JSONObject jsonParam) {
        boolean rememberMe = true;
        JSONObject result = new JSONObject();
        User user = JSON.parseObject(jsonParam.toJSONString(),User.class);
        String password = MD5Utils.encrypt(user.getUserName(), user.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), password,rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            result.put("router", "default");
            result.put("method", "json");
            result.put("msg","LoginSuccess");
            result.put("username", user.getUserName());
            result.put("userType", user.getUserType());
        } catch (UnknownAccountException e) {
            result.put("method", "json");
            result.put("router","LoginPage");
            result.put("msg","UnknownAccount");
        } catch (IncorrectCredentialsException e) {
            result.put("method", "json");
            result.put("router","LoginPage");
            result.put("msg","IncorrectCredentials");
        } catch (LockedAccountException e) {
            result.put("method", "json");
            result.put("router","LoginPage");
            result.put("msg","LockedAccount");
        } catch (AuthenticationException e) {
            result.put("method", "json");
            result.put("router","LoginPage");
            result.put("msg","UnAuthentication");
        }
        return result.toJSONString();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String logout() {
        JSONObject result = new JSONObject();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            //session.removeAttribute("user");
            result.put("router", "index");
            result.put("code", "200");
            result.put("msg", "退出成功");
        } catch (Exception e) {
            result.put("code", "-1");
            result.put("msg", "退出异常");
        }
        return result.toJSONString();
    }



    @RequestMapping("/index")
    public String index() {
        if(SecurityUtils.getSubject().isAuthenticated()){
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            System.out.println(user.getUserName());
        }
        else{
            System.out.println("guest");
        }
        return "index";
    }

    @RequestMapping("/")
    public String RedirectIndex() {
        return "redirect:/index";
    }

    //获取登陆用户
    @GetMapping("/getLoginUser")
    @ResponseBody
    public String getLoginUser(){
        if(SecurityUtils.getSubject().isAuthenticated()){
            User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
            JSONObject json  = new JSONObject();
            json.put("username",loginUser.getUserName());
            json.put("userType",loginUser.getUserType());
            return json.toJSONString();
        }
        else{
            JSONObject json= new JSONObject();
            json.put("username","guest");
            json.put("userType","guest");
            return json.toJSONString();
        }
    }



}