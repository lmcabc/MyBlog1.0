package com.lmc.service;

import com.lmc.dao.TypeMapper;
import com.lmc.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    @Override
    public List<Type> getAllTypeIndex() {
        return typeMapper.getAllTypeIndex();
    }

    @Override
    public Type getTypeById(Long id) {
        return typeMapper.getTypeById(id);
    }

    @Transactional
    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public int deleteTypeById(Long id) {
        return typeMapper.deleteTypeById(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

}
