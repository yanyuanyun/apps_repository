package com.zhiyun.service;

import com.zhiyun.dao.FindUser;
import com.zhiyun.domian.User;

public class Service {
    public User check(User user){
        return FindUser.find(user);
    }
}
