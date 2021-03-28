package com.yangzehan.workbench.Controller;

import com.yangzehan.workbench.domain.ActivityRemark;
import com.yangzehan.workbench.service.ActivityRemarkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ActivityRemarkController {
    @Resource
    private ActivityRemarkService service;
    @ResponseBody
    @RequestMapping(value = "/getRemarks.do")
    public List<ActivityRemark>geRemark(HttpServletRequest request){
        String  id = request.getParameter("id");
        List<ActivityRemark> list=service.getRemark(id);
        return list;
    }



}
