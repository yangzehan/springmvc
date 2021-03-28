package com.yangzehan.service;

import com.yangzehan.EX.nameEX;
import com.yangzehan.domaim.User;

import java.util.List;

public interface UserService {
   User login(User user) throws nameEX;
}
