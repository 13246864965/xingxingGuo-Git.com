package com.cn.hwyl.pojo;

import java.util.Date;

import com.cn.hwyl.pojo.request.PageInputContext;

public class Role extends PageInputContext{
    private String cRoleid;

    private String cRolename;

    private String cRolecode;

    private String cSuatus;

    private String cUpdateuserid;

    private Date cUpdatedate;

    private Integer cRoletype;

    private String cOrgcode;

    private String cOrgid;

    public String getcRoleid() {
        return cRoleid;
    }

    public void setcRoleid(String cRoleid) {
        this.cRoleid = cRoleid == null ? null : cRoleid.trim();
    }

    public String getcRolename() {
        return cRolename;
    }

    public void setcRolename(String cRolename) {
        this.cRolename = cRolename == null ? null : cRolename.trim();
    }

    public String getcRolecode() {
        return cRolecode;
    }

    public void setcRolecode(String cRolecode) {
        this.cRolecode = cRolecode == null ? null : cRolecode.trim();
    }

    public String getcSuatus() {
        return cSuatus;
    }

    public void setcSuatus(String cSuatus) {
        this.cSuatus = cSuatus == null ? null : cSuatus.trim();
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

    public Integer getcRoletype() {
        return cRoletype;
    }

    public void setcRoletype(Integer cRoletype) {
        this.cRoletype = cRoletype;
    }

    public String getcOrgcode() {
        return cOrgcode;
    }

    public void setcOrgcode(String cOrgcode) {
        this.cOrgcode = cOrgcode == null ? null : cOrgcode.trim();
    }

    public String getcOrgid() {
        return cOrgid;
    }

    public void setcOrgid(String cOrgid) {
        this.cOrgid = cOrgid == null ? null : cOrgid.trim();
    }

	@Override
	public String toString() {
		return "Role [cRoleid=" + cRoleid + ", cRolename=" + cRolename + ", cRolecode=" + cRolecode + ", cSuatus="
				+ cSuatus + ", cUpdateuserid=" + cUpdateuserid + ", cUpdatedate=" + cUpdatedate + ", cRoletype="
				+ cRoletype + ", cOrgcode=" + cOrgcode + ", cOrgid=" + cOrgid + "]";
	}
    
    
}