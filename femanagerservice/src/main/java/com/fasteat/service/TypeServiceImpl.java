package com.fasteat.service;

import com.fasteat.server.dao.TypeMapper;
import com.fasteat.server.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper  typeMapper;
    @Override
    public List<Type> selectTypeByRid(Integer rid) {
        return typeMapper.selectTypeByRid(rid);
    }
}
