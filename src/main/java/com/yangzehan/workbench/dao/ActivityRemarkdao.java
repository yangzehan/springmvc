package com.yangzehan.workbench.dao;

import com.yangzehan.workbench.domain.ActivityRemark;

import java.util.List;

public interface ActivityRemarkdao {
    int getcoutnAid(String[] id);

    int deletecountAid(String[] id);

    List<ActivityRemark> getRemark(String id);
}
