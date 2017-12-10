package com.fasteat.service;

import com.fasteat.server.pojo.Food;

import java.util.List;

public interface FoodService {

    List<Food> selectAll();
    List<Food> selectFoodByTid(Integer tid);
    Food selectFoodByFid(Integer fid);

}
