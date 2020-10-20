package com.egg.crm.filter;

import com.egg.crm.settings.domain.DicValue;
import com.egg.crm.settings.service.DicService;
import com.egg.crm.settings.service.impl.DicServiceImpl;
import com.egg.crm.utils.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SysInitListener implements ServletContextListener {

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

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
