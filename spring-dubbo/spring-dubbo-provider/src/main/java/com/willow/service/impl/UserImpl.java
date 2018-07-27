package com.willow.service.impl;

import com.willow.entity.User;
import com.willow.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserService {
    @Override
    public List<User> selectList(User user) {
        List<User> list=new ArrayList<User>();
        list.add(new User(1,"yangliu",29));
        list.add(new User(2,"lisi",19));
        return list;
    }
}
