package com.fasteat.server.pojo;

import java.io.Serializable;
import java.util.List;

public class Food  {
    private Integer fid;

    private String fname;

    private Integer tid;

    private Double fprice;

    private String fdesc;

    private Integer fnum;

    private String fphoto;

    private Integer count;

    private List<Item> FItem;

    public List<Item> getFItem() {
        return FItem;
    }

    public void setFItem(List<Item> FItem) {
        this.FItem = FItem;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Double getFprice() {
        return fprice;
    }

    public void setFprice(Double fprice) {
        this.fprice = fprice;
    }

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }

    public Integer getFnum() {
        return fnum;
    }

    public void setFnum(Integer fnum) {
        this.fnum = fnum;
    }

    public String getFphoto() {
        return fphoto;
    }

    public void setFphoto(String fphoto) {
        this.fphoto = fphoto;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}