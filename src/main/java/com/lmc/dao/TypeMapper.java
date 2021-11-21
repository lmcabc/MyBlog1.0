package com.lmc.dao;

import com.lmc.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {

    List<Type> getAllType();

    //根据id查询type
    Type getTypeById(Long id);

    //添加type
    int addType(Type type);

    //通过name查询type
    Type getTypeByName(String name);

    //删除
    int deleteTypeById(Long id);

    //通过名字修改type
    int updateType(Type type);

    //获取所有的type，包括blogs
    List<Type> getAllTypeIndex();
}
