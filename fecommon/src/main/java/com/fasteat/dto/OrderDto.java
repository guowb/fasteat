package com.fasteat.dto;

import com.fasteat.server.pojo.Item;
import com.fasteat.server.pojo.Order;

import java.text.SimpleDateFormat;
import java.util.List;

public class OrderDto {

    private Integer id;

    private Double price;

    private String createdate;

    private Integer ostatus;

    private Integer dnum;

    private String content;

    private Long phone;

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public OrderDto()
    {

    }

    public OrderDto(Integer id, Double price, String createdate, Integer ostatus, Integer dnum, String content, Long phone, List<Item> items) {
        this.id = id;
        this.price = price;
        this.createdate = createdate;
        this.ostatus = ostatus;
        this.dnum = dnum;
        this.content = content;
        this.phone = phone;
        this.items = items;
    }
    public OrderDto(Order order){
        this.id = order.getId();
        this.price = order.getPrice();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS ");
        this.createdate = simpleDateFormat.format(order.getCreatedate());
        this.ostatus = order.getOstatus();
        this.dnum = order.getDnum();
        this.content = order.getContent();
        this.phone = order.getPhone();
        this.items = order.getItems();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public Integer getOstatus() {
        return ostatus;
    }

    public void setOstatus(Integer ostatus) {
        this.ostatus = ostatus;
    }

    public Integer getDnum() {
        return dnum;
    }

    public void setDnum(Integer dnum) {
        this.dnum = dnum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
