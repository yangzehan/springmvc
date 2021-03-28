package com.yangzehan.hdel;

import com.yangzehan.EX.nameEX;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class exchuli {
    @ExceptionHandler(value = nameEX.class)
    @ResponseBody
    public Map<String, Object> EXchuli(Exception ex) throws IOException {
        Map<String, Object> map = new HashMap();
         map.put("key",false);
         map.put("msg",ex.getMessage());
        System.out.println(ex);
       return map;
    }
}
