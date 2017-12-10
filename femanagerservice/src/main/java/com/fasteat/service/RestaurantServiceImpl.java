package com.fasteat.service;

import com.fasteat.server.dao.RestaurantMapper;
import com.fasteat.server.pojo.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantMapper restaurantMapper;
    @Override
    public Restaurant selectRestaurantByRid(Integer rid) {
        return restaurantMapper.selectByPrimaryKey(rid);
    }
}
