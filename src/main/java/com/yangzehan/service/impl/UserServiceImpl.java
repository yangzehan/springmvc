package com.yangzehan.service.impl;

import com.yangzehan.EX.nameEX;
import com.yangzehan.dao.Userdao;
import com.yangzehan.domaim.User;
import com.yangzehan.service.UserService;
import org.springframework.stereotype.Service;
import com.yangzehan.utils.DateTimeUtil;
import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private Userdao userdao;
    @Override
    public User login(User user) throws nameEX {

        User user1=userdao.select(user);
        if (user1==null){
            throw new nameEX("账号密码不对");
        }
        String ip=user.getAllowIps();
        if (!user1.getAllowIps().contains(ip)){
            throw new nameEX("ip地址错误");
        }
        String time=DateTimeUtil.getSysTime();
        if (user1.getExpireTime().compareTo(time)<0){
            throw new nameEX("账号已经过期了"+user1.getExpireTime());
        }
    return  user1;
    }
}
