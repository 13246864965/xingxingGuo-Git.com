package com.cn.hwyl.pojo;

import java.util.Date;

import com.cn.hwyl.pojo.request.PageInputContext;

public class FirstaidResults extends PageInputContext{
    private String cResultsid;

    private String cFirstaidid;

    private String cUpdateuserid;

    private Date cUpdatetime;

    private Integer cResultstype;
    private String cReason;

    private String cResultsnote;

    public String getcReason() {
        return cReason;
    }

    public void setcReason(String cReason) {
        this.cReason = cReason == null ? null : cReason.trim();
    }

    public String getcResultsnote() {
        return cResultsnote;
    }

    public void setcResultsnote(String cResultsnote) {
        this.cResultsnote = cResultsnote == null ? null : cResultsnote.trim();
    }
    public String getcResultsid() {
        return cResultsid;
    }

    public void setcResultsid(String cResultsid) {
        this.cResultsid = cResultsid == null ? null : cResultsid.trim();
    }

    public String getcFirstaidid() {
        return cFirstaidid;
    }

    public void setcFirstaidid(String cFirstaidid) {
        this.cFirstaidid = cFirstaidid == null ? null : cFirstaidid.trim();
    }

    public String getcUpdateuserid() {
        return cUpdateuserid;
    }

    public void setcUpdateuserid(String cUpdateuserid) {
        this.cUpdateuserid = cUpdateuserid == null ? null : cUpdateuserid.trim();
    }

    public Date getcUpdatetime() {
        return cUpdatetime;
    }

    public void setcUpdatetime(Date cUpdatetime) {
        this.cUpdatetime = cUpdatetime;
    }

    public Integer getcResultstype() {
        return cResultstype;
    }

    public void setcResultstype(Integer cResultstype) {
        this.cResultstype = cResultstype;
    }

	@Override
	public String toString() {
		return "FirstaidResults [cResultsid=" + cResultsid + ", cFirstaidid=" + cFirstaidid + ", cUpdateuserid="
				+ cUpdateuserid + ", cUpdatetime=" + cUpdatetime + ", cResultstype=" + cResultstype + ", cReason="
				+ cReason + ", cResultsnote=" + cResultsnote + "]";
	}
    
}