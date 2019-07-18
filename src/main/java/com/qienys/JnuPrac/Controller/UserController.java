package com.qienys.JnuPrac.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.pojo.UserInfo;
import com.qienys.JnuPrac.service.impl.UserInfoServiceImpl;
import com.qienys.JnuPrac.service.impl.UserServiceImpl;
import com.qienys.JnuPrac.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {
    @Autowired
    private UserInfoServiceImpl userInfoServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;

    //获取用户信息
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String register(@RequestBody JSONObject jsonParam) {
        //System.out.println(jsonParam.toJSONString());
        JSONObject json = new JSONObject();
        User user = JSON.parseObject(jsonParam.toJSONString(),User.class);
        if(!userServiceImpl.existsByUserName(user.getUserName())){
            user.setPassword(MD5Utils.encrypt(user.getUserName(),user.getPassword()));
            user.setCreateTime(new Date());
            user.setStatus(true);
            user.setUserType("user");
            userServiceImpl.save(user);
            json.put("msg","register success");
            json.put("router","default");
        }else {
            json.put("msg","username already exist");
            json.put("router","register");
        }

        return json.toJSONString();
    }
    //获取用户信息
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String postUserInfo(@RequestBody JSONObject jsonParam) {
        //System.out.println(jsonParam.toJSONString());
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        User user = JSON.parseObject(jsonParam.toJSONString(),User.class);
        User loginUser = userServiceImpl.findByUserName(user.getUserName());
        //System.out.println(loginUser.getUserName());
        UserInfo userInfo = userInfoServiceImpl.findByUid(loginUser.getId());
        json.put("router", "/QueryUserInfo");
        json.put("method", "json");
        json.put("username", user.getUserName());
        json.put("userType", user.getUserType());
        //前端大哥说先放jsonUser
        jsonArray.add(json);
        jsonArray.add(userInfo);
        //System.out.println(jsonArray.toJSONString());
        return jsonArray.toJSONString();
    }

    //改密码用静态类
    private static class VO {
        private Long id;
        private String password;
        private Map<String, Object> attributes = new HashMap<String, Object>();
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Map<String, Object> getAttributes() { return attributes;}
    }
    //改密码
    @RequestMapping(value = "/passwdModify", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passwdModify(@RequestBody JSONObject jsonParam) {
        //newpassword password
        ExtraProcessor processor = new ExtraProcessor() {
            public void processExtra(Object object, String key, Object value) {
                VO vo = (VO) object;
                vo.getAttributes().put(key, value);
            }
        };
        System.out.println(jsonParam.toJSONString());
        VO vo = JSON.parseObject(jsonParam.toJSONString(),VO.class,processor);
        vo.getAttributes().get("newpassword");
        //User loginUser = userServiceImpl.findByUserName("user");//test
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        UserInfo userInfo = userInfoServiceImpl.findByUid(loginUser.getId());
        String password = vo.getPassword();
        password = MD5Utils.encrypt(loginUser.getUserName(),password);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        if(password.equals(loginUser.getPassword())){
            //修改密码 保存
            String newPassword = MD5Utils.encrypt(loginUser.getUserName(), vo.getAttributes().get("newpassword").toString());
            loginUser.setPassword(newPassword);
            userServiceImpl.save(loginUser);
            result.put("method", "json");
            result.put("router", "default");
            result.put("msg","ModifySuccess");
            result.put("username", loginUser.getUserName());
            result.put("userType", loginUser.getUserType());
            jsonArray.add(result);
            jsonArray.add(userInfo);
        }
        else{
            result.put("method", "json");
            result.put("router", "QueryDataPage/:username");
            result.put("msg","WrongPassword");
            result.put("username", loginUser.getUserName());
            result.put("userType", loginUser.getUserType());
            jsonArray.add(result);
            jsonArray.add(userInfo);

        }

        return jsonArray.toJSONString();

    }

    @RequestMapping(value = "/userInfoModify", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String userInfoModify(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam.toJSONString());
        //User loginUser = userServiceImpl.findByUserName("user");//test
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        UserInfo tempUserInfo = JSON.parseObject(jsonParam.toJSONString(),UserInfo.class);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        userInfoServiceImpl.save(tempUserInfo);
        UserInfo userInfo = JSON.parseObject(jsonParam.toJSONString(),UserInfo.class);
        result.put("method", "json");
        result.put("router", "QueryDataPage/:username");
        result.put("msg","ModifySuccess");
        result.put("username", loginUser.getUserName());
        result.put("userType", loginUser.getUserType());
        jsonArray.add(result);
        jsonArray.add(userInfo);


        return jsonArray.toJSONString();

    }


    //管理员用
    @ResponseBody
    @GetMapping("getAllUsers")
    public String getAllUsers(){
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        List<User> userList = userServiceImpl.findAll();
        jsonArray.add(json.toJSONString());
        jsonArray.add(userList);
        return jsonArray.toJSONString();
    }

    //测试用
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
        jsonUser.put("userType", loginUser.getUserType());

        jsonArray.add(jsonUser);
        jsonArray.add(userInfo);
        return jsonArray.toJSONString();
    }



}
