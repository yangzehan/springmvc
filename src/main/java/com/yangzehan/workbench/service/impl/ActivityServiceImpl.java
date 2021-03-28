package com.yangzehan.workbench.service.impl;

import com.yangzehan.dao.Userdao;
import com.yangzehan.domaim.User;
import com.yangzehan.vo.pagevo;
import com.yangzehan.workbench.dao.ActivityRemarkdao;
import com.yangzehan.workbench.dao.Activitydao;
import com.yangzehan.workbench.domain.Activity;

import com.yangzehan.workbench.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {
        @Resource
    private Activitydao activitydao;
        @Resource
        private Userdao userdao;
        @Resource
        private ActivityRemarkdao activityRemarkdao;

    @Override
    public List<User> find() {
        List<User>list= activitydao.find();
        return list;
    }

    @Override
    public int save(Activity activity) {

        int num =activitydao.add(activity);

        return num;
    }



    @Override
    public pagevo<Activity> pagelist(Map<String, Object> map) {


        int count=activitydao.count(map);
        List<Activity>list=activitydao.selectall(map);

        pagevo<Activity> vo=new pagevo<Activity>();
        vo.setList(list);
        vo.setTotal(count);
       return vo;
    }

    @Override
    public boolean delete(String[] id) {
        boolean flag=true;

        //查询需要删除的备注的数量
       int count1=  activityRemarkdao.getcoutnAid(id);

        //删除备注，返回受影响的条数；
     int count2 =  activityRemarkdao.deletecountAid(id);

        if (count1!=count2){
            flag=false;
        }

        //删除市场操作
       int count3= activitydao.delete(id);

        if (count3!= id.length){
            flag=false;
        }
        return flag;
    }

    @Override
    public Map<String, Object> getUandA(String id) {
        //取Userlist
       List<User> Userlist=userdao.getUserlist();
       //取a
        Activity a=activitydao.getActivity(id);

     Map<String, Object>map=new HashMap<>();
     map.put("Userlist",Userlist);
     map.put("a",a);


return map;




    }

    @Override
    public boolean updateA(Activity activity) {
       boolean n=false;

       int num = activitydao.updateA(activity);
       if (num==1){
       n=true;
}

        return n;
    }

    @Override
    public Activity detail(String id) {

        Activity activity=activitydao.detail(id);
        return activity;
    }
}
