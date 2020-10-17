package com.egg.crm.workbench.service.impl;

import com.egg.crm.utils.SqlSessionUtil;
import com.egg.crm.workbench.dao.ActivityDao;
import com.egg.crm.workbench.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

}
