package com.fasteat.dto;


import com.fasteat.server.pojo.Order;

import java.util.List;

/**
 * @author hrc
 */
public class ITDto {

    private long total;
    private List rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Order> getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
