package com.yangzehan.workbench.Controller;

import com.yangzehan.domaim.User;
import com.yangzehan.utils.DateTimeUtil;
import com.yangzehan.utils.UUIDUtil;
import com.yangzehan.vo.pagevo;
import com.yangzehan.workbench.domain.Activity;

import com.yangzehan.workbench.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ActivityController {
    @Resource
    private ActivityService service;

    @ResponseBody
    @RequestMapping(value = "/save.do")
    public boolean save(HttpServletRequest request, Activity activity) {
        boolean n = false;
        activity.setId(UUIDUtil.getUUID());
        activity.setCreateTime(DateTimeUtil.getSysTime());
        activity.setCreateBy(((User) request.getSession().getAttribute("user")).getName());
       
        int num = service.save(activity);

        if (num > 0) {
            n = true;
        }
        return n;
    }

    @ResponseBody
    @RequestMapping(value = "/pagefind.do")
    public pagevo pagelist(HttpServletRequest request) {
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String startDate = request.getParameter("starDate");
        String endDate = request.getParameter("endDate");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        Integer PageNo = Integer.valueOf(pageNo);
        Integer PageSize = Integer.valueOf(pageSize);
        int skipcount = (PageNo - 1) * PageSize;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name",name);
        map.put("owner",owner);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("PageNo",skipcount);
        map.put("PageSize",PageSize);
        System.out.println(map.get("owner"));
        pagevo<Activity> vo = service.pagelist(map);


        return vo;

    }
    @RequestMapping(value = "delete.do")
    @ResponseBody
    public boolean delete(HttpServletRequest request){
      String[] id=  request.getParameterValues("id");
     boolean n= service.delete(id);


     return  n;
    }
    @ResponseBody
    @RequestMapping(value = "/getUandA.do")
    public Map<String, Object> getUandA(HttpServletRequest request){
        String id=  request.getParameter("id");
      Map<String, Object> map=  service.getUandA(id);

return map;


    }
    @ResponseBody
    @RequestMapping(value = "/update.do")
    public boolean update(HttpServletRequest request,Activity activity){
        boolean n;
        activity.setEditTime(DateTimeUtil.getSysTime());
        activity.setEditBy(((User) request.getSession().getAttribute("user")).getName());
        n=  service.updateA(activity);
return  n;
    }
    @ResponseBody
    @RequestMapping(value = "/detail.do")
    public ModelAndView detail(HttpServletRequest request){
        String id=request.getParameter("id");
        Activity activity=service.detail(id);
      ModelAndView mv=new ModelAndView();
      mv.addObject("a",activity);
      mv.setViewName("forward:/workbench/activity/detail.jsp");
return mv;
    }

}
