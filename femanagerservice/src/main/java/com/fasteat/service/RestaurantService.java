package com.fasteat.service;

import com.fasteat.server.pojo.Restaurant;

public interface RestaurantService {
    Restaurant selectRestaurantByRid(Integer rid);
}
