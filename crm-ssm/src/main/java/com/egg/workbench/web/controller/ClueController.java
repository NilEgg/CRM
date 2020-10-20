package com.egg.workbench.web.controller;

import com.egg.settings.service.UserService;
import com.egg.workbench.service.ActivityService;
import com.egg.workbench.service.ClueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;


@Controller
public class ClueController extends HttpServlet {

    @Resource
    private ActivityService as;
    @Resource
    private UserService us;
    @Resource
    private ClueService cs;

    /*@RequestMapping(value = "/workbench/activity/updateRemark.do")
    @ResponseBody
    private Map<String,Object> updateRemark() {
        System.out.println("执行修改备注操作");

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",1);
        return map;
        //PrintJson.printJsonObj(response,map);

    }*/



}
