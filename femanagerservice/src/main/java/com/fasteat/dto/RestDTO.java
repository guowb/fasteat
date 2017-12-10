package com.fasteat.dto;

import com.fasteat.server.pojo.Restaurant;

import java.util.List;

public class RestDTO {
    private  Long total;
    private List<Restaurant> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Restaurant> getRows() {
        return rows;
    }

    public void setRows(List<Restaurant> rows) {
        this.rows = rows;
    }
}
