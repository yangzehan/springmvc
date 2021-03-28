package com.yangzehan.Controller;

import com.yangzehan.EX.nameEX;
import com.yangzehan.domaim.User;
import com.yangzehan.service.UserService;
import com.yangzehan.utils.DateTimeUtil;
import com.yangzehan.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService service;
    @RequestMapping(value = "/login.do")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, User user) throws nameEX {
     user.setLoginPwd(MD5Util.getMD5(user.getLoginPwd()));
     String ip=request.getRemoteAddr();
     user.setAllowIps(ip);
        System.out.println(ip);
        User user1= service.login(user);

         Map<String, Object>map=new HashMap<>();
         request.getSession().setAttribute("user",user1);
         map.put("key",true);
         map.put("msg","登陆成功");

       return map;

    }



}
