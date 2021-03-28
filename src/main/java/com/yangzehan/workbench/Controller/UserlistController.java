package com.yangzehan.workbench.Controller;

import com.yangzehan.domaim.User;
import com.yangzehan.workbench.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserlistController {
    @Resource
    private ActivityService service;
    @ResponseBody
    @RequestMapping(value = "/finduser.do")
    public List<User>find(){
        List<User>list=service.find();
        return list;

    }
}
