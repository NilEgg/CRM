package com.egg.settings.test;

import com.egg.crm.utils.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test1 {
    public static void main(String[] args) {
        String expireTime = "2020-11-10 10:10:10";
        String currentTime = DateTimeUtil.getSysTime();

        int count = expireTime.compareTo(currentTime);

        String lockState = "0";
        if ("0".equals(lockState)){
            System.out.println("账号已锁定");
        }

    }
}
