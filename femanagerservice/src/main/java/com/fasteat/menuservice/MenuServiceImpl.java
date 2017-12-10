package com.fasteat.menuservice;

import com.fasteat.server.dao.FoodMapper;
import com.fasteat.server.dao.ItemMapper;
import com.fasteat.server.dao.OrderMapper;
import com.fasteat.server.dao.TypeMapper;
import com.fasteat.server.pojo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired private TypeMapper typeMapper;
    @Autowired private FoodMapper foodMapper;
    @Autowired private OrderMapper orderMapper;
    @Autowired private ItemMapper itemMapper;

    @Override
    public void addType(Type type) {
        typeMapper.insert(type);
    }

    @Override
    public void delType(Integer id) {
        typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Type> getAllType(Integer id) {
        TypeExample typeExample = new TypeExample();
        TypeExample.Criteria criteria = typeExample.createCriteria();
        criteria.andTnameIsNotNull();
        criteria.andRidEqualTo(id);
        return typeMapper.selectByExample(typeExample);
    }

    @Override
    public void updateType(Type type) {
        typeMapper.updateByPrimaryKey(type);
    }


    @Override
    public Type getTypeByID(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addFood(Food food) {
        foodMapper.insert(food);
    }

    @Override
    public void delFood(Integer id) {
        foodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Food getFoodByID(Integer id) {
        return foodMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Food> getAllFood(Integer rid) {
        TypeExample typeExample = new TypeExample();
        TypeExample.Criteria criteria = typeExample.createCriteria();
        criteria.andRidEqualTo(rid);
        List<Type> typeList = typeMapper.selectByExample(typeExample);
        List<Food> foodList = new ArrayList<>();
        for (Type type : typeList) {
            FoodExample foodExample = new FoodExample();
            FoodExample.Criteria criteria1 = foodExample.createCriteria();
            criteria1.andTidEqualTo(type.getTid());
            foodList.addAll(foodMapper.selectByExample(foodExample)) ;
        }
        return foodList;
    }

    @Override
    public void updateFood(Food food) {
        foodMapper.updateByPrimaryKey(food);
    }

    @Override
    public List<Food> getAllFoodByType(Integer tid) {
        return foodMapper.selectFoodByTid(tid);
    }

    @Override
    public List<Order> getOrderByOstatus(Integer ostatus,Integer rid) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andRidEqualTo(rid).andOstatusEqualTo(ostatus);
        orderExample.setOrderByClause("createdate DESC");
        List<Order> list = orderMapper.selectByExample(orderExample);
        return list;
    }

    @Override
    public OrderDto2 getOrderDetails(Integer oid) {
        OrderDto2 orderDto2 = new OrderDto2();
        Order order = orderMapper.selectByPrimaryKey(oid);
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria= itemExample.createCriteria();
        criteria.andOidEqualTo(oid);
        List<Item> itemList = itemMapper.selectByExample(itemExample);
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (Item item : itemList) {
            ItemDto itemDto = new ItemDto();
            BeanUtils.copyProperties(item,itemDto);
            Food food = foodMapper.selectByPrimaryKey(item.getFid());
            itemDto.setFname(food.getFname());
            itemDtoList.add(itemDto);
        }
        BeanUtils.copyProperties(order,orderDto2);
        orderDto2.setItemDtoList(itemDtoList);
        return orderDto2;
    }


}
