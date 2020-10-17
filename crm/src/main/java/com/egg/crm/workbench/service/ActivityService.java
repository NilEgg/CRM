package com.egg.crm.workbench.service;

import com.egg.crm.vo.PaginationVO;
import com.egg.crm.workbench.domain.Activity;

import java.util.Map;

public interface ActivityService {
    boolean save(Activity a);

    PaginationVO<Activity> pageList(Map<String, Object> map);
}
