package com.lmc.service;

import com.lmc.dao.UserMapper;
import com.lmc.pojo.User;
import com.lmc.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByUsername(String username, String password) {
        return userMapper.queryUserByUsername(username, MD5Utils.code(password));
    }
}
