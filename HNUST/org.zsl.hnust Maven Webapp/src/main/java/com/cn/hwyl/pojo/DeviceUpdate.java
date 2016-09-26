package com.cn.hwyl.pojo;

import java.util.Date;

public class DeviceUpdate {
    private String cWardshipid;

    private String cFirstaidid;

    private String cDevicenumber;

//    private Date cDeviceupdatetime;
    private String cDeviceupdatetime;

    private String cUpdateuserid;

//    private Date cUpdatetime;
    private String cUpdatetime;

//    private Date cReturntime;
    private String cReturntime;
    
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


    public String getcUpdateuserid() {
        return cUpdateuserid;
    }

    public void setcUpdateuserid(String cUpdateuserid) {
        this.cUpdateuserid = cUpdateuserid == null ? null : cUpdateuserid.trim();
    }


	public String getcDeviceupdatetime() {
		return cDeviceupdatetime;
	}

	public void setcDeviceupdatetime(String cDeviceupdatetime) {
		this.cDeviceupdatetime = cDeviceupdatetime;
	}

	public String getcUpdatetime() {
		return cUpdatetime;
	}

	public void setcUpdatetime(String cUpdatetime) {
		this.cUpdatetime = cUpdatetime;
	}

	public String getcReturntime() {
		return cReturntime;
	}

	public void setcReturntime(String cReturntime) {
		this.cReturntime = cReturntime;
	}

	@Override
	public String toString() {
		return "DeviceUpdate [cWardshipid=" + cWardshipid + ", cFirstaidid=" + cFirstaidid + ", cDevicenumber="
				+ cDevicenumber + ", cDeviceupdatetime=" + cDeviceupdatetime + ", cUpdateuserid=" + cUpdateuserid
				+ ", cUpdatetime=" + cUpdatetime + ", cReturntime=" + cReturntime + "]";
	}
}