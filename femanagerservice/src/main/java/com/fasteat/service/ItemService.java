package com.fasteat.service;

import com.fasteat.server.pojo.Food;
import com.fasteat.server.pojo.Item;

import java.util.List;

public interface ItemService {

    List<Item> selectItemfromOId(Integer oid);

    void addNewItem(Item item);

    void setFoodItem(Integer fid,Item item);
}
