package com.cn.hwyl.pojo;

import java.util.Date;

import com.cn.hwyl.pojo.request.PageInputContext;

public class Permissions extends PageInputContext{
    private String cPrivilegeid;

    private String cPrivilegename;

    private String cPrivilegecode;

    private String cPrivilegetype;

    private Integer cSortno;

    private String cStatus;

    private String cUpdateuserid;

    private Date cUpdatedate;

    public String getcPrivilegeid() {
        return cPrivilegeid;
    }

    public void setcPrivilegeid(String cPrivilegeid) {
        this.cPrivilegeid = cPrivilegeid == null ? null : cPrivilegeid.trim();
    }

    public String getcPrivilegename() {
        return cPrivilegename;
    }

    public void setcPrivilegename(String cPrivilegename) {
        this.cPrivilegename = cPrivilegename == null ? null : cPrivilegename.trim();
    }

    public String getcPrivilegecode() {
        return cPrivilegecode;
    }

    public void setcPrivilegecode(String cPrivilegecode) {
        this.cPrivilegecode = cPrivilegecode == null ? null : cPrivilegecode.trim();
    }

    public String getcPrivilegetype() {
        return cPrivilegetype;
    }

    public void setcPrivilegetype(String cPrivilegetype) {
        this.cPrivilegetype = cPrivilegetype == null ? null : cPrivilegetype.trim();
    }

    public Integer getcSortno() {
        return cSortno;
    }

    public void setcSortno(Integer cSortno) {
        this.cSortno = cSortno;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus == null ? null : cStatus.trim();
    }

    public String getcUpdateuserid() {
        return cUpdateuserid;
    }

    public void setcUpdateuserid(String cUpdateuserid) {
        this.cUpdateuserid = cUpdateuserid == null ? null : cUpdateuserid.trim();
    }

    public Date getcUpdatedate() {
        return cUpdatedate;
    }

    public void setcUpdatedate(Date cUpdatedate) {
        this.cUpdatedate = cUpdatedate;
    }

	@Override
	public String toString() {
		return "Permissions [cPrivilegeid=" + cPrivilegeid + ", cPrivilegename=" + cPrivilegename + ", cPrivilegecode="
				+ cPrivilegecode + ", cPrivilegetype=" + cPrivilegetype + ", cSortno=" + cSortno + ", cStatus="
				+ cStatus + ", cUpdateuserid=" + cUpdateuserid + ", cUpdatedate=" + cUpdatedate + "]";
	}
    
}