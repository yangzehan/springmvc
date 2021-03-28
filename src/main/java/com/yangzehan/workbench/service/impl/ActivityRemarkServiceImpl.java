package com.yangzehan.workbench.service.impl;

import com.yangzehan.workbench.dao.ActivityRemarkdao;
import com.yangzehan.workbench.domain.ActivityRemark;
import com.yangzehan.workbench.service.ActivityRemarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ActivityRemarkServiceImpl implements ActivityRemarkService {
    @Resource
    private ActivityRemarkdao activityRemarkdao;

    @Override
    public List<ActivityRemark> getRemark(String id) {
       List<ActivityRemark> list= activityRemarkdao.getRemark(id);
        System.out.println(list);
       return list;
    }
}
