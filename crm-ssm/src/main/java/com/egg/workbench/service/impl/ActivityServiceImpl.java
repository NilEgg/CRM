package com.egg.workbench.service.impl;

import com.egg.settings.dao.UserDao;
import com.egg.settings.domain.User;
import com.egg.utils.SqlSessionUtil;
import com.egg.vo.PaginationVO;
import com.egg.workbench.dao.ActivityDao;
import com.egg.workbench.dao.ActivityRemarkDao;
import com.egg.workbench.domain.Activity;
import com.egg.workbench.domain.ActivityRemark;
import com.egg.workbench.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityDao activityDao;
    @Resource
    private ActivityRemarkDao activityRemarkDao;
    @Resource
    private UserDao userDao;

    public boolean save(Activity a) {
        boolean flag = true;
        int count = activityDao.save(a);
        if(count != 1){
            flag = false;
        }
        return flag;
    }

    public PaginationVO<Activity> pageList(Map<String, Object> map) {
        int total = activityDao.getTotalByCondition(map);
        List<Activity> dataList = activityDao.getActivityListByCondition(map);
        PaginationVO<Activity> vo = new PaginationVO<Activity>();
        vo.setTotal(total);
        vo.setDataList(dataList);

        return vo;
    }

    public boolean delete(String[] ids) {
        boolean flag = true;
        //查询删除备注的数量
        int count1 = activityRemarkDao.getCountByAids(ids);

        //删除备注，返回受到影响条数（实际删除数量）
        int count2 = activityRemarkDao.deleteByAids(ids);

        if (count1 != count2){
            flag = false;
        }
        //删除市场活动
        int count3 = activityDao.delete(ids);
        if (count3 != ids.length){
            flag = false;
        }
        return flag;
    }

    public Map<String, Object> getUserListAndActivity(String id) {
        List<User> uList = userDao.getUserList();

        Activity a = activityDao.getById(id);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("uList",uList);
        map.put("a",a);

        return map;
    }

    public boolean update(Activity a) {
        boolean flag = true;
        int count = activityDao.update(a);
        if(count != 1){
            flag = false;
        }

        return flag;
    }

    public Activity detail(String id) {
        Activity a = activityDao.detail(id);
        return a;
    }

    public List<ActivityRemark> getRemarkListByAid(String activityId) {
        List<ActivityRemark> arList = activityRemarkDao.getRemarkListByAid(activityId);
        System.out.println("service获取的id======" + activityId);
        return arList;
    }

    public boolean deleteRemark(String id) {
        boolean flag = true;
        int count = activityRemarkDao.deleteById(id);
        if (count != 1){
            flag = false;
        }
        return flag;
    }

    public boolean saveRemark(ActivityRemark ar) {
        boolean flag = true;
        int count = activityRemarkDao.saveRemark(ar);
        if(count != 1){
            flag = false;
        }
        return flag;
    }

    public boolean updateRemark(ActivityRemark ar) {
        boolean flag = true;
        int count = activityRemarkDao.updateRemark(ar);

        if(count != 1){
            flag = false;
        }

        return flag;
    }
}
