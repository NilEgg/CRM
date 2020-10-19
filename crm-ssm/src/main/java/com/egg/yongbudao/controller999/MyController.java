/*
package com.egg.yongbudao.controller999;

import com.egg.exception.AgeException;
import com.egg.exception.LoginException;
import com.egg.exception.MyUserException;
import com.egg.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyController {

    @RequestMapping(value = "/some.do")

    public ModelAndView doSome(String name,Integer age) throws LoginException {
        ModelAndView mv = new ModelAndView();
        if(!"zs".equals(name)){
            throw new LoginException("姓名错误");
        }
        if(age == null || age > 80){
            throw new AgeException("年龄较大");
        }
        mv.addObject("myname",name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "/other.do")
    public ModelAndView doOther(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        return mv;
    }
}
*/
