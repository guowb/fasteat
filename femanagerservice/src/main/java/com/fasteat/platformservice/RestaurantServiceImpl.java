package com.fasteat.platformservice;

import com.fasteat.dto.RestDTO;
import com.fasteat.server.dao.RestaurantMapper;
import com.fasteat.server.pojo.Restaurant;
import com.fasteat.server.pojo.RestaurantExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantMapper restaurantMapper;
    @Override
    public int addRest(Restaurant restaurant) {

        restaurantMapper.insertSelective(restaurant);
        return restaurant.getRid();
    }

    @Override
    public int updateRest(Restaurant restaurant) {
        int i = restaurantMapper.updateByPrimaryKeySelective(restaurant);
        return i;
    }

    @Override
    public Restaurant getRestById(Integer id) {
        Restaurant restaurant = restaurantMapper.selectByPrimaryKey(id);
        return restaurant;
    }

    @Override
    public RestDTO getAllRest(Integer page,Integer rows) {
        System.out.println("进来了");
       PageHelper.startPage(page,rows);
        RestaurantExample example = new RestaurantExample();
        RestaurantExample.Criteria  criteria = example.createCriteria();
        criteria.andRcodeIsNotNull();
      List<Restaurant> list = restaurantMapper.selectByExample(example);
        System.out.println("数据");
        PageInfo<Restaurant> pageInfo= new PageInfo(list);
        RestDTO dto =new RestDTO();
       dto.setRows(list);
        dto.setTotal(pageInfo.getTotal());

        return dto;
    }

    @Override
    public Integer getIdByName(String rname) {
      /*  RestaurantExample e = new RestaurantExample();
        RestaurantExample.Criteria criteria = e.createCriteria();
        criteria.andRnameEqualTo(rname);
        restaurantMapper.selectByExample(e);*/
        int id = restaurantMapper.getIdByName(rname);
        return id;
    }

    @Override
    public void delRest(Integer rid) {
        restaurantMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public Restaurant getRestByRphone(Long rphone) {
        RestaurantExample example =  new RestaurantExample();
        RestaurantExample.Criteria criteria = example.createCriteria();
        criteria.andRphoneEqualTo(rphone);
        List<Restaurant> list = restaurantMapper.selectByExample(example);
        if(list.size()>0){
        Restaurant restaurant = list.get(0);
        return restaurant;}
        return null;

    }
}
