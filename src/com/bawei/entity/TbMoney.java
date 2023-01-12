package com.bawei.entity;

import java.util.Date;

public class TbMoney {
    private Integer mid;

    private String mname;

    private Date mdate;

    private Double msum;
    
    private Double mbalance;
    

    public Double getMbalance() {
		return mbalance;
	}

	public void setMbalance(Double mbalance) {
		this.mbalance = mbalance;
	}

	public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public Double getMsum() {
        return msum;
    }

    public void setMsum(Double msum) {
        this.msum = msum;
    }
}