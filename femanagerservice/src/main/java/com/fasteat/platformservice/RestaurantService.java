package com.fasteat.platformservice;

import com.fasteat.dto.RestDTO;
import com.fasteat.server.pojo.Restaurant;

public interface RestaurantService {
    int addRest(Restaurant restaurant);
    int updateRest(Restaurant restaurant);
    Restaurant getRestById(Integer id);
    RestDTO getAllRest(Integer page, Integer rows);
    Integer getIdByName(String rname);
    void delRest(Integer rid);
    Restaurant getRestByRphone(Long rphone);


}
