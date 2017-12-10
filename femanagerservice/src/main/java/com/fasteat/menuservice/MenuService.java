package com.fasteat.menuservice;


import com.fasteat.server.pojo.Food;
import com.fasteat.server.pojo.Order;
import com.fasteat.server.pojo.Type;

import java.util.List;

public interface MenuService {
    public void addType(Type type);
    public void delType(Integer id);
    public List<Type> getAllType(Integer id);
    public void updateType(Type type);
    public Type getTypeByID(Integer id);
    public void addFood(Food food);
    public void delFood(Integer id);
    public Food getFoodByID(Integer id);
    public List<Food> getAllFood(Integer rid);
    public void updateFood(Food food);
    public List<Food> getAllFoodByType(Integer tid);
    public List<Order> getOrderByOstatus(Integer ostatus, Integer rid);
    public OrderDto2 getOrderDetails(Integer oid);
}
