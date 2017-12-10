package com.fasteat.service;

import com.fasteat.server.pojo.Type;

import java.util.List;

public interface TypeService {
    List<Type> selectTypeByRid(Integer rid);
}
