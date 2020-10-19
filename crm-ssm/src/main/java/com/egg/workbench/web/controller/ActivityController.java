package com.egg.workbench.web.controller;

import com.egg.settings.domain.User;
import com.egg.settings.service.UserService;
import com.egg.utils.DateTimeUtil;
import com.egg.utils.UUIDUtil;
import com.egg.vo.PaginationVO;
import com.egg.workbench.domain.Activity;
import com.egg.workbench.domain.ActivityRemark;
import com.egg.workbench.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionAttributes(value = {"a"})
@Controller
public class ActivityController extends HttpServlet {

    @Resource
    private ActivityService as;
    @Resource
    private UserService us;

    @RequestMapping(value = "/workbench/activity/updateRemark.do")
    @ResponseBody
    private void updateRemark(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行修改备注操作");
        String id = request.getParameter("id");
        String noteContent = request.getParameter("noteContent");
        String editTime = DateTimeUtil.getSysTime();
        String editBy = ((User)request.getSession().getAttribute("user")).getName();
        String editFlag = "1";

        ActivityRemark ar = new ActivityRemark();
        ar.setId(id);
        ar.setNoteContent(noteContent);
        ar.setEditFlag(editFlag);
        ar.setEditBy(editBy);
        ar.setEditTime(editTime);


        boolean flag = as.updateRemark(ar);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",flag);
        map.put("ar",ar);
        //PrintJson.printJsonObj(response,map);

    }

    @RequestMapping(value = "/workbench/activity/saveRemark.do")
    @ResponseBody
    private void saveRemark(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行添加备注操作");
        String noteContent = request.getParameter("noteContent");
        String activityId = request.getParameter("activityId");
        String id = UUIDUtil.getUUID();
        String createTime = DateTimeUtil.getSysTime();
        String createBy = ((User)request.getSession().getAttribute("user")).getName();
        String editFlag = "0";

        ActivityRemark ar = new ActivityRemark();
        ar.setId(id);
        ar.setNoteContent(noteContent);
        ar.setActivityId(activityId);
        ar.setCreateBy(createBy);
        ar.setCreateTime(createTime);
        ar.setEditFlag(editFlag);

        boolean flag = as.saveRemark(ar);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",flag);
        map.put("ar",ar);
        //PrintJson.printJsonObj(response,map);
    }

    @RequestMapping(value = "/workbench/activity/deleteRemark.do")
    @ResponseBody
    private void deleteRemark(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("删除备注操作");
        String id = request.getParameter("id");

        boolean flag = as.deleteRemark(id);
        //PrintJson.printJsonFlag(response,flag);
    }

    @RequestMapping(value = "/workbench/activity/getRemarkListByAid.do")
    @ResponseBody
    private void getRemarkListByAid(HttpServletRequest request) {
        System.out.println("根据市场活动取得备注信息列表");
        String activityId = request.getParameter("activityId");
        System.out.println("获取的id======" + activityId);

        List<ActivityRemark> arList = as.getRemarkListByAid(activityId);


        //PrintJson.printJsonObj(response,arList);
    }

    @RequestMapping(value = "/workbench/activity/detail.do")
    @ResponseBody
    private ModelAndView detail(String id,ModelMap modelMap) {
        System.out.println("进入到跳转详细信息页的操作");
        Activity a = as.detail(id);

        modelMap.addAttribute("a",a);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("a",a);
        modelAndView.setViewName("forward:/workbench/activity/detail.jsp");
        return modelAndView;
        /*request.setAttribute(,a);
        request.getRequestDispatcher("/workbench/activity/detail.jsp").forward(request,response);*/
    }

    @RequestMapping(value = "/workbench/activity/update.do")
    @ResponseBody
    private Map<String,Boolean> update(Activity activity, HttpServletRequest request, ModelMap modelMap) {
        System.out.println("执行市场活动修改操作");
        String editTime = DateTimeUtil.getSysTime();
        String editBy = ((User)request.getSession().getAttribute("user")).getName();
        String edit = ((User)modelMap.get("user")).getName();
        System.out.println("edit------>"+edit);

        Activity a = new Activity();
        a.setId(activity.getId());
        a.setOwner(activity.getOwner());
        a.setName(activity.getName());
        a.setStartDate(activity.getStartDate());
        a.setEndDate(activity.getEndDate());
        a.setCost(activity.getCost());
        a.setDescription(activity.getDescription());
        a.setEditTime(editTime);
        a.setEditBy(editBy);

        boolean flag = as.update(a);

        Map<String,Boolean> map = new HashMap<>();
        map.put("success",flag);
        return map;
    }

    @RequestMapping(value = "/workbench/activity/getUserListAndActivity.do")
    @ResponseBody
    private Map<String,Object> getUserListAndActivity(HttpServletRequest request) {
        System.out.println("执行查询用户信息列表，根据市场活动id查询单条记录操作");
        String id = request.getParameter("id");

        Map<String,Object> map = as.getUserListAndActivity(id);
        return map;
    }

    @RequestMapping(value = "/workbench/activity/delete.do")
    @ResponseBody
    private Map<String,Boolean> delete(HttpServletRequest request) {
        System.out.println("执行市场活动删除操作");
        String[] ids = request.getParameterValues("id");

        boolean flag = as.delete(ids);

        Map<String,Boolean> map = new HashMap<>();
        map.put("success",flag);
        return map;
    }

    @RequestMapping(value = "/workbench/activity/pageList.do")
    @ResponseBody
    private PaginationVO<Activity> pageList(String name,String owner,String startDate,String endDate,String pageNo,String pageSize) {

        System.out.println("执行查询市场活动信息列表操作（结合条件查询+分页查询）");

        int intPageNo = Integer.valueOf(pageNo);
        int intPageSize = Integer.valueOf(pageSize);
        int skipCount = (intPageNo-1) * intPageSize;

        Map<String,Object> map = new HashMap<String, Object>();

        map.put("name",name);
        map.put("owner",owner);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("skipCount",skipCount);
        map.put("pageSize",intPageSize);

        PaginationVO<Activity> vo = as.pageList(map);

        return vo;
    }

    @RequestMapping(value = "/workbench/activity/save.do")
    @ResponseBody
    private Map<String,Boolean> save(Activity activity,HttpServletRequest request) {
        System.out.println("执行市场活动添加操作");

        String id = UUIDUtil.getUUID();
        String createTime = DateTimeUtil.getSysTime();
        String createBy = ((User)request.getSession().getAttribute("user")).getName();

        Activity a = new Activity();
        a.setId(id);
        a.setOwner(activity.getOwner());
        a.setName(activity.getName());
        a.setStartDate(activity.getStartDate());
        a.setEndDate(activity.getEndDate());
        a.setCost(activity.getCost());
        a.setDescription(activity.getDescription());
        a.setCreateTime(createTime);
        a.setCreateBy(createBy);

        boolean flag = as.save(a);
        Map<String,Boolean> map = new HashMap<>();
        map.put("success",flag);
        return map;

    }

    @RequestMapping(value = "/workbench/activity/getUserList.do")
    @ResponseBody
    private List<User> getUserList() {
        System.out.println("取得用户信息列表");

        List<User> uList = us.getUserList();

        System.out.println("用户信息列表：");
        for (User user : uList){
            System.out.println(user);
        }

        return uList;
    }

}
