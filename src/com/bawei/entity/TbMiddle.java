package com.bawei.entity;

public class TbMiddle extends TbMiddleKey {
	
    private Double mcount;//购买金额
    private String mname;//基金名称

    public Double getMcount() {
        return mcount;
    }

    public void setMcount(Double mcount) {
        this.mcount = mcount;
    }

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
    
    
}