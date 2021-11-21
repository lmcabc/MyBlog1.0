package com.lmc.service;

import com.lmc.pojo.Type;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TypeService {

    //获取所有的type
    List<Type> getAllType();

    //获取所有的type，包括blogs
    List<Type> getAllTypeIndex();

    //根据id查询type
    Type getTypeById(Long id);

    //添加type
    int addType(Type type);

    //通过name查询type
    Type getTypeByName(String name);

    //删除
    int deleteTypeById(Long id);

    //修改type
    int updateType(Type type);
}
