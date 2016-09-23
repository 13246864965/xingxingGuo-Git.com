package com.cn.hwyl.pojo;

import java.util.Date;

public class FirstaidCollection {
    private String cCollectionid;

    private String cFirstaidinfoid;

    private String cFirstaidid;

    private String cUpdateuserid;

    private Date cUpdatetime;

    public String getcCollectionid() {
        return cCollectionid;
    }

    public void setcCollectionid(String cCollectionid) {
        this.cCollectionid = cCollectionid == null ? null : cCollectionid.trim();
    }

    public String getcFirstaidinfoid() {
        return cFirstaidinfoid;
    }

    public void setcFirstaidinfoid(String cFirstaidinfoid) {
        this.cFirstaidinfoid = cFirstaidinfoid == null ? null : cFirstaidinfoid.trim();
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

	@Override
	public String toString() {
		return "FirstaidCollection [cCollectionid=" + cCollectionid + ", cFirstaidinfoid=" + cFirstaidinfoid
				+ ", cFirstaidid=" + cFirstaidid + ", cUpdateuserid=" + cUpdateuserid + ", cUpdatetime=" + cUpdatetime
				+ "]";
	}
}