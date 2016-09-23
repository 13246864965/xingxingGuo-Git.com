package com.cn.hwyl.pojo;

import java.util.Date;

public class DeviceUpdate {
    private String cWardshipid;

    private String cFirstaidid;

    private String cDevicenumber;

    private Date cDeviceupdatetime;

    private String cUpdateuserid;

    private Date cUpdatetime;

    private Date cReturntime;
    
private int count;
    
    
    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

    public String getcWardshipid() {
        return cWardshipid;
    }

    public void setcWardshipid(String cWardshipid) {
        this.cWardshipid = cWardshipid == null ? null : cWardshipid.trim();
    }

    public String getcFirstaidid() {
        return cFirstaidid;
    }

    public void setcFirstaidid(String cFirstaidid) {
        this.cFirstaidid = cFirstaidid == null ? null : cFirstaidid.trim();
    }

    public String getcDevicenumber() {
        return cDevicenumber;
    }

    public void setcDevicenumber(String cDevicenumber) {
        this.cDevicenumber = cDevicenumber == null ? null : cDevicenumber.trim();
    }

    public Date getcDeviceupdatetime() {
        return cDeviceupdatetime;
    }

    public void setcDeviceupdatetime(Date cDeviceupdatetime) {
        this.cDeviceupdatetime = cDeviceupdatetime;
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

    public Date getcReturntime() {
        return cReturntime;
    }

    public void setcReturntime(Date cReturntime) {
        this.cReturntime = cReturntime;
    }

	@Override
	public String toString() {
		return "DeviceUpdate [cWardshipid=" + cWardshipid + ", cFirstaidid=" + cFirstaidid + ", cDevicenumber="
				+ cDevicenumber + ", cDeviceupdatetime=" + cDeviceupdatetime + ", cUpdateuserid=" + cUpdateuserid
				+ ", cUpdatetime=" + cUpdatetime + ", cReturntime=" + cReturntime + "]";
	}
}