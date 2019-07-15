package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qienys.JnuPrac.pojo.ResponseBo;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class TestController {

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam.toJSONString());
        JSONObject result = new JSONObject();
        User user = JSON.parseObject(jsonParam.toJSONString(),User.class);
        //System.out.println(user.getUsername()+" "+user.getPassword());
        String password = MD5Utils.encrypt(user.getUsername(), user.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            result.put("router", "LoginSuccess");
            result.put("method", "json");
            result.put("username", user.getUsername());
            result.put("usertype", user.getUsertype());
        } catch (UnknownAccountException e) {
            result.put("router","UnknownAccount");
            result.put("method", "json");
        } catch (IncorrectCredentialsException e) {
            result.put("router","IncorrectCredentials");
            result.put("method", "json");
        } catch (LockedAccountException e) {
            result.put("router","LockedAccount");
            result.put("method", "json");
        } catch (AuthenticationException e) {
            result.put("router","login");
            result.put("method", "json");
        }
        return result.toJSONString();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
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
            result.put("code", "-1");
            result.put("msg", "退出异常");
        }
        return result.toJSONString();
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        System.out.println("index");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }


}