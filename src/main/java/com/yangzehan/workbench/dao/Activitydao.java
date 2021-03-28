package com.yangzehan.workbench.dao;

import com.yangzehan.domaim.User;
import com.yangzehan.vo.pagevo;
import com.yangzehan.workbench.domain.Activity;


import java.util.List;
import java.util.Map;

public interface Activitydao {
     Activity getActivity(String id);

    List<User>find();
    int add(Activity activity);

    int count(Map<String, Object> map);

    List<Activity> selectall(Map<String, Object> map);

    int delete(String[] id);

    int updateA(Activity activity);

    Activity detail(String id);
}
