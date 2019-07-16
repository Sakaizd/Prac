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




@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam.toJSONString());
        JSONObject result = new JSONObject();
        User user = JSON.parseObject(jsonParam.toJSONString(),User.class);
        System.out.println(user.getUserName()+" "+user.getPassword());
        String password = MD5Utils.encrypt(user.getUserName(), user.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            result.put("router", "default");
            result.put("method", "json");
            result.put("username", user.getUserName());
            result.put("userType", user.getUserType());
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
            result.put("router","UnAuthentication");
            result.put("method", "json");
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
        //System.out.println("index page");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }

}