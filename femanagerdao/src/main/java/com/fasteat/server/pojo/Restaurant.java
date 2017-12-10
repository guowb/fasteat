package com.fasteat.server.pojo;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private Integer rid;

    private String rname;

    private Long rphone;

    private String rcode;

    private String rdesc;

    private Long rmaxday;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Long getRphone() {
        return rphone;
    }

    public void setRphone(Long rphone) {
        this.rphone = rphone;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public Long getRmaxday() {
        return rmaxday;
    }

    public void setRmaxday(Long rmaxday) {
        this.rmaxday = rmaxday;
    }
}