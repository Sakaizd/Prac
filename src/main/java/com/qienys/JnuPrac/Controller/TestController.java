package com.qienys.JnuPrac.Controller;

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
public class TestController {

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        System.out.println(username+"  "+password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResponseBo.ok();
        } catch (UnknownAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseBo.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }
}