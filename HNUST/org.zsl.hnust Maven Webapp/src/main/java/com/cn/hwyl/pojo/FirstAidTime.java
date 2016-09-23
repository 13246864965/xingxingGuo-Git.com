package com.cn.hwyl.pojo;

import java.util.Date;

public class FirstAidTime {
    private String cTimeid;

    private String cFirstaidid;

    private Date cTime;

    private String cTimetype;

    private String cUpdateuserid;

    private String cTimenote;
    
    private int count;
    

    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getcTimeid() {
        return cTimeid;
    }

    public void setcTimeid(String cTimeid) {
        this.cTimeid = cTimeid == null ? null : cTimeid.trim();
    }

    public String getcFirstaidid() {
        return cFirstaidid;
    }

    public void setcFirstaidid(String cFirstaidid) {
        this.cFirstaidid = cFirstaidid == null ? null : cFirstaidid.trim();
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getcTimetype() {
        return cTimetype;
    }

    public void setcTimetype(String cTimetype) {
        this.cTimetype = cTimetype == null ? null : cTimetype.trim();
    }

    public String getcUpdateuserid() {
        return cUpdateuserid;
    }

    public void setcUpdateuserid(String cUpdateuserid) {
        this.cUpdateuserid = cUpdateuserid == null ? null : cUpdateuserid.trim();
    }

    public String getcTimenote() {
        return cTimenote;
    }

    public void setcTimenote(String cTimenote) {
        this.cTimenote = cTimenote == null ? null : cTimenote.trim();
    }

	@Override
	public String toString() {
		return "FirstAidTime [cTimeid=" + cTimeid + ", cFirstaidid=" + cFirstaidid + ", cTime=" + cTime + ", cTimetype="
				+ cTimetype + ", cUpdateuserid=" + cUpdateuserid + ", cTimenote=" + cTimenote + ", count=" + count
				+ ", getCount()=" + getCount() + ", getcTimeid()=" + getcTimeid() + ", getcFirstaidid()="
				+ getcFirstaidid() + ", getcTime()=" + getcTime() + ", getcTimetype()=" + getcTimetype()
				+ ", getcUpdateuserid()=" + getcUpdateuserid() + ", getcTimenote()=" + getcTimenote() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
}