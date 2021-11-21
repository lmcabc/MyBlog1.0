package com.lmc.service;

import com.lmc.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User queryUserByUsername(String username, String password);
}
