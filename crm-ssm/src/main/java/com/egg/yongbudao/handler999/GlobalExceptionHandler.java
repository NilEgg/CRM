/*
package com.egg.yongbudao.handler999;

import com.egg.exception.AgeException;
import com.egg.exception.LoginException;
import com.egg.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = LoginException.class)
    public ModelAndView doNameException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","姓名必须是zs");
        mv.addObject("ex",exception);
        mv.setViewName("nameError");
        return mv;
    }

    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","年龄不能大于80");
        mv.addObject("ex",exception);
        mv.setViewName("ageError");
        return mv;
    }

    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","异常！");
        mv.addObject("ex",exception);
        mv.setViewName("defaultError");
        return mv;
    }
}
*/
