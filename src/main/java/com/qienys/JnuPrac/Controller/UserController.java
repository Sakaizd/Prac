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
    public String getUserInfo(@RequestBody JSONObject jsonParam) {
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

    @PostMapping(value = "/userInfoModify", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String userInfoModify(@RequestBody JSONObject jsonParam) {
        //User loginUser = userServiceImpl.findByUserName("user");//test
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        UserInfo tempUserInfo = JSON.parseObject(jsonParam.toJSONString(),UserInfo.class);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        userInfoServiceImpl.save(tempUserInfo);
        UserInfo userInfo = JSON.parseObject(jsonParam.toJSONString(),UserInfo.class);
        result.put("router", "QueryDataPage/:username");
        result.put("msg","ModifySuccess");
        result.put("username", loginUser.getUserName());
        result.put("userType", loginUser.getUserType());
        jsonArray.add(result);
        jsonArray.add(userInfo);
        return jsonArray.toJSONString();

    }


    //管理员用
/*    @ResponseBody
    @GetMapping("/getAllUsers")
    public String getAllUsers(){
        JSONObject json = new JSONObject();
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        if(loginUser.getUserType().equals("admin")) {
            List<User> userList = userServiceImpl.findAll();
            return JSON.toJSONString(userList);
        }
        else {
            json.put("msg","UnAuthentication");
            json.put("router","");
            return json.toJSONString();

        }
    }*/

    @ResponseBody
    @GetMapping("/getAllUserInfosByAdmin")
    public String getAllUserInfosByAdmin(){
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        if(loginUser.getUserType().equals("admin")) {
            JSONArray jsonArray = new JSONArray();
            List<UserInfo> userInfosList = userInfoServiceImpl.findAll();
            for(UserInfo userInfo : userInfosList){
                JSONObject json = new JSONObject();
                json.put("address",userInfo.getAddress());
                json.put("email",userInfo.getEmail());
                json.put("idCard",userInfo.getIdcard());
                json.put("name",userInfo.getName());
                json.put("pswAns",userInfo.getPswAns());
                json.put("pswQues",userInfo.getPswQues());
                json.put("telephone",userInfo.getTelephone());
                json.put("uid",userInfo.getUid());
                json.put("username",userServiceImpl.findById(userInfo.getUid()).getUserName());
                jsonArray.add(json);
            }
            return jsonArray.toJSONString();
        }
        else {
            JSONObject json = new JSONObject();
            json.put("msg","UnAuthentication");
            json.put("router","");
            return json.toJSONString();
        }
    }

/*    //管理员获取用户信息
    @PostMapping(value = "/getUserInfoByAdmin", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getUserInfoByAdmin(@RequestBody JSONObject jsonParam) {
        //Request userName
        //User loginUser = userServiceImpl.findByUserName("user");//test
        JSONObject json = new JSONObject();
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        if(loginUser.getUserType().equals("admin")){
            User tempUser= JSON.parseObject(jsonParam.toJSONString(),User.class);
            User user = userServiceImpl.findByUserName(tempUser.getUserName());
            UserInfo tempUserInfo = userInfoServiceImpl.findByUid(user.getId());
            json.put("userInfo", tempUserInfo);
            json.put("router","");
        }
        else {
            json.put("msg","UnAuthentication");
            json.put("router","");
        }

        return json.toJSONString();

    }*/

    ////管理员修改用户信息
    @PostMapping(value = "/ModifyUserInfoByAdmin", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ModifyUserInfoByAdmin(@RequestBody JSONObject jsonParam) {
        //Request userInfo(all)
        JSONObject json = new JSONObject();
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        if(loginUser.getUserType().equals("admin")){
            UserInfo tempUserInfo= JSON.parseObject(jsonParam.toJSONString(),UserInfo.class);
            userInfoServiceImpl.save(tempUserInfo);
            json.put("msg","success");
            json.put("router","");
            json.put("userInfo", tempUserInfo);
        }
        else {
            json.put("router","");
            json.put("msg","UnAuthentication");
        }

        return json.toJSONString();

    }

    @PostMapping(value = "/resetPassword", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String resetPassword(@RequestBody JSONObject jsonParam) {
        //Request username
        JSONObject json = new JSONObject();
        User loginUser = (User) SecurityUtils.getSubject().getPrincipal();
        if(loginUser.getUserType().equals("admin")){
            User tempUser= JSON.parseObject(jsonParam.toJSONString(),User.class);
            User user = userServiceImpl.findByUserName(tempUser.getUserName());
            user.setPassword(MD5Utils.encrypt(user.getUserName(),"123"));
            userServiceImpl.save(user);
            json.put("msg","success");
        }
        else {
            json.put("router","");
            json.put("msg","UnAuthentication");
        }

        return json.toJSONString();

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
