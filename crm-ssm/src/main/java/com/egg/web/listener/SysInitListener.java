package com.egg.web.listener;

import com.egg.settings.domain.DicValue;
import com.egg.settings.service.DicService;
import com.egg.settings.service.impl.DicServiceImpl;
import com.egg.utils.ServiceFactory;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SysInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("上下文域对象");
        ServletContext application = event.getServletContext();
        System.out.println("application---->"+application);
        DicService ds = (DicService) ServiceFactory.getService(new DicServiceImpl());
        System.out.println("ds--------->"+ds);

        Map<String, List<DicValue>> map = ds.getAll();
        Set<String> set = map.keySet();
        for (String key: set) {
            application.setAttribute(key,map.get(key));
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
