package com.yangzehan.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangzehan.domaim.Student;
import com.yangzehan.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class Studentconntroller {
    @Resource
    private StudentService service;
    @ResponseBody
    @RequestMapping(value ="Add.do")
   public ModelAndView add(Student student){
        int num=service.add(student);
        ModelAndView mv=new ModelAndView();
        if (num>0){

            mv.addObject("name",student.getName());
            mv.addObject("age",student.getAge());
            mv.setViewName("show");
            return mv;
        }
        mv.addObject("name",student.getName());
        mv.setViewName("zuceshibai");
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "/find.do")
public List<Student> find()  {
        List<Student> list=service.find();

      return list;




}

}
