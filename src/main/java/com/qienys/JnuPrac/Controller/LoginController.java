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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody JSONObject jsonParam) {
        Boolean rememberMe = true;
        System.out.println("json:"+jsonParam.toJSONString());
        JSONObject result = new JSONObject();
        User user = JSON.parseObject(jsonParam.toJSONString(),User.class);
        //System.out.println(user.getUserName()+" "+user.getPassword());
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
            result.put("code", "200");
            result.put("msg", "退出成功");
        } catch (Exception e) {
            result.put("code    ", "-1");
            result.put("msg", "退出异常");
        }
        return result.toJSONString();
    }



    @RequestMapping("/index")
    public String index(Model model) {
        if(SecurityUtils.getSubject().isAuthenticated()){
            System.out.println("user: login user");
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(user);
            String jsonString= jsonArray.toJSONString();
            model.addAttribute("json",jsonString);
        }
        else{
            JSONObject json= new JSONObject();
            json.put("username","guest");
            json.put("userType","guest");
            String jsonString= json.toJSONString();
            model.addAttribute("json",jsonString);
        }
        return "index";
    }

    @GetMapping("/getLoginUser")
    @ResponseBody
    public String getLoginUser(){
        if(SecurityUtils.getSubject().isAuthenticated()){
            System.out.println("login user:");
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            System.out.println(user.getUserName());
            JSONObject jsonstring  = new JSONObject();
            jsonstring.put("username",user.getUserName());
            jsonstring.put("userType",user.getUserType());
            return jsonstring.toJSONString();
        }
        else{
            System.out.println("guest");
            JSONObject json= new JSONObject();
            json.put("username","guest");
            json.put("userType","guest");
            String jsonString= json.toJSONString();
            return jsonString;
        }
    }

   /* @RequestMapping("/**")
    public String redirectIndex() {
        return "redirect:/index";
    }*/

}