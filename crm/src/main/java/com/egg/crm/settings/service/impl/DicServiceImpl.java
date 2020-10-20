/*
package com.egg.crm.settings.service.impl;

import com.egg.crm.settings.service.DicService;
import com.egg.crm.settings.dao.DicTypeDao;
import com.egg.crm.settings.dao.DicValueDao;
import com.egg.crm.settings.domain.DicType;
import com.egg.crm.settings.domain.DicValue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DicServiceImpl implements DicService {
    @Resource
    private DicTypeDao dicTypeDao;
    @Resource
    private DicValueDao dicValueDao;


    @Override
    public Map<String, List<DicValue>> getAll() {
        System.out.println("service取出字典");
        Map<String, List<DicValue>> map = new HashMap<>();
        //取出字典类型
        System.out.println("继续");
        List<DicType> dtList = dicTypeDao.getTypeList();
        System.out.println("继续1");
        for (DicType dt: dtList){
            String code = dt.getCode();
            List<DicValue> dvList = dicValueDao.getListByCode(code);
            map.put(code,dvList);
        }
        System.out.println("结束");
        return map;
    }
}
*/
