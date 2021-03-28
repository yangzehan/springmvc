package com.yangzehan.dao;

import com.yangzehan.domaim.User;

import java.util.List;

public interface Userdao {
    User select(User user);

    List<User> getUserlist();
}
