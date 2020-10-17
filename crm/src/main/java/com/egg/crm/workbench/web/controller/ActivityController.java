package com.egg.crm.workbench.web.controller;

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

public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入市场活动控制器");
        String path = request.getServletPath();
        if("/workbench/activity/xxx.do".equals(path)){
            //xxx(request,response);
        }else if("/workbench/activity/xxx.do".equals(path)){
            //xxx(request,response);
        }
    }

}
