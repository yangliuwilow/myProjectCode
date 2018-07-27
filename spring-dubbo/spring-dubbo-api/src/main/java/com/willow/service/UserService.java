package com.willow.service;

import com.willow.entity.User;

import java.util.List;


public interface UserService   {

      List<User> selectList(User user);
}
