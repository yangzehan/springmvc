package com.yangzehan.workbench.service;

import com.yangzehan.domaim.User;
import com.yangzehan.vo.pagevo;
import com.yangzehan.workbench.domain.Activity;


import java.util.List;
import java.util.Map;

public interface ActivityService {
    List<User>find();
    int save(Activity activity);
    pagevo<Activity> pagelist(Map<String, Object> map);

    boolean delete(String[] id);

    Map<String, Object> getUandA(String id);

    boolean updateA(Activity activity);

    Activity detail(String id);
}
