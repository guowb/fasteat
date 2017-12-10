package com.fasteat.service;

import com.fasteat.server.dao.FoodMapper;
import com.fasteat.server.dao.ItemMapper;
import com.fasteat.server.pojo.Food;
import com.fasteat.server.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Item> selectItemfromOId(Integer oid) {
        return itemMapper.selectItemfromOId(oid);
    }

    @Override
    public void addNewItem(Item item) {
        itemMapper.insertSelective(item);
    }

    @Override
    public void setFoodItem(Integer fid,Item item) {
        //查找出fid food
        Food food = foodMapper.selectByPrimaryKey(fid);
        System.out.println(food.getFname());
        item.setFood(food);

    }
}
