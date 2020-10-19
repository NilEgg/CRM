package com.egg.settings.web.controller;

import com.egg.exception.LoginException;
import com.egg.settings.domain.User;
import com.egg.settings.service.UserService;
import com.egg.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@SessionAttributes(value = {"user"})
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/settings/user/login.do")
    @ResponseBody
    public Map<String, Object> login(User user, HttpServletRequest request, ModelMap modelMap){
        System.out.println("进入验证登录操作");
        String loginAct = user.getLoginAct() ;
        String loginPwd = MD5Util.getMD5(user.getLoginPwd());
        user.setLoginPwd(loginPwd);
        String ip = request.getRemoteAddr();
        System.out.println("ip--->" + ip);

        Map<String ,Object> map = new HashMap<>();

        try {
            User user1 = userService.login(loginAct,loginPwd,ip);
            modelMap.addAttribute("user",user1);
            map.put("success",true);
            return map;

        } catch (Exception e) {

            e.printStackTrace();
            String msg = e.getMessage();

            map = new HashMap<>();
            map.put("success",false);
            map.put("msg",msg);
            return map;
        }

    }

}
