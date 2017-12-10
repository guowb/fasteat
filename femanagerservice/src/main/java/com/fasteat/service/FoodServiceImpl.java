package com.fasteat.service;

import com.fasteat.server.dao.FoodMapper;
import com.fasteat.server.pojo.Food;
import com.fasteat.server.pojo.FoodExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

   /* @Override
    public List<Food> selectAll() {
        return foodMapper.selectAll();
    }*/

    @Override
    public List<Food> selectAll() {
        FoodExample foodExample=new FoodExample();
        return foodMapper.selectByExample(foodExample);
    }

    @Override
    public List<Food> selectFoodByTid(Integer tid) {
        List<Food> foods = foodMapper.selectFoodByTid(tid);
        return foods;
    }

    @Override
    public Food selectFoodByFid(Integer fid) {
        Food food=foodMapper.selectByPrimaryKey(fid);
        return food;
    }
}
