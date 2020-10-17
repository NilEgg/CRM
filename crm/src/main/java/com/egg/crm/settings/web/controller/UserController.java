package com.egg.crm.settings.web.controller;

import com.egg.crm.settings.domain.User;
import com.egg.crm.settings.service.UserService;
import com.egg.crm.settings.service.impl.UserServiceImpl;
import com.egg.crm.utils.MD5Util;
import com.egg.crm.utils.PrintJson;
import com.egg.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入用户控制器");
        String path = request.getServletPath();
        if("/settings/user/login.do".equals(path)){
            login(request,response);
        }else if("/settings/user/xxx.do".equals(path)){
            //xxx(request,response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入验证登录操作");
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        loginPwd = MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();
        System.out.println("ip--->" + ip);

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        System.out.println("0000");
        try {
            System.out.println("111");
            User user = us.login(loginAct,loginPwd,ip);
            System.out.println("222");
            request.getSession().setAttribute("user",user);
            System.out.println("333");
            PrintJson.printJsonFlag(response,true);
            System.out.println("444");
        }catch (Exception e){
            e.printStackTrace();
            String msg = e.getMessage();

            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);
        }


    }
}
