package com.fasteat.service;

import com.fasteat.dto.ITDto;
import com.fasteat.server.pojo.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface OrderService {

    void addNewOrder(Order order);
    List<Order> selectOByOstatus();

    PageInfo<Order> selectByPage(Integer pageIndex);

    Order selectItemfromOId(Integer id);

    void updateByOstatus(Integer id);

    ITDto findOrderList(Integer page, Integer rows);

    Order selectOrderByPhone(Long phone);

}
