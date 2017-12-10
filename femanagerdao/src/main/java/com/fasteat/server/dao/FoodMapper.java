package com.fasteat.server.dao;

import com.fasteat.server.pojo.Food;
import com.fasteat.server.pojo.FoodExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodMapper {
    int countByExample(FoodExample example);

    int deleteByExample(FoodExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Food record);

    int insertSelective(Food record);

    List<Food> selectAll();

    //通过种类id 进行查询
    List<Food> selectFoodByTid(Integer tid);


    List<Food> selectByExample(FoodExample example);

    Food selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByExample(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);

}