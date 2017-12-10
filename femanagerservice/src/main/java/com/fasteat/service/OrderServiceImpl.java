package com.fasteat.service;


import com.fasteat.dto.ITDto;
import com.fasteat.dto.OrderDto;
import com.fasteat.server.dao.ItemMapper;
import com.fasteat.server.dao.OrderMapper;
import com.fasteat.server.pojo.Item;
import com.fasteat.server.pojo.Order;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ItemMapper itemMapper;

    //创建订单
    @Override
    public void addNewOrder(Order order) {
        int i = orderMapper.insertSelective(order);
        System.out.println(i+"-----------------------------------");
    }

    @Override
    public List<Order> selectOByOstatus() {
        return orderMapper.selectOByOstatus();
    }


    @Override
    public Order selectItemfromOId(Integer id) {

        Order order=orderMapper.selectByPrimaryKey(id);
        List<Item> items=itemMapper.selectItemfromOId(id);
        order.setItems(items);
        return order;
    }

    @Override
    public void updateByOstatus(Integer id) {
        orderMapper.updateByOstatus(id);
    }

    @Override
    public PageInfo<Order> selectByPage(Integer pageIndex) {
        Integer pageSize=4;
        PageHelper.startPage(pageIndex,pageSize,"id");
        List<Order> orders=orderMapper.selectOByOstatus();
        PageInfo<Order> pageInfo=new PageInfo<Order>(orders,5);
        return pageInfo;
    }

    @Override
    public ITDto findOrderList(Integer page, Integer rows) {

        PageHelper.startPage(page,rows);
        List<Order> orders=orderMapper.selectOByOstatus();
        //分页处理
        PageInfo<Order> pageInfo = new PageInfo<Order>(orders);
        List<OrderDto> orderDtos=new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto=new OrderDto(order);
            orderDtos.add(orderDto);
        }
        long total = pageInfo.getTotal();
        pageInfo.getPageNum();

        //返回内容，前台使用
        ITDto itDto=new ITDto();
        itDto.setTotal(total);
        itDto.setRows(orderDtos);

        return itDto;
    }

    @Override
    public Order selectOrderByPhone(Long phone) {
        return orderMapper.selectOrderByPhone(phone);
    }
}
