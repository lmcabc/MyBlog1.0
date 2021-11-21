package com.lmc.dao;

import com.lmc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User queryUserByUsername(String username, String password);
}
