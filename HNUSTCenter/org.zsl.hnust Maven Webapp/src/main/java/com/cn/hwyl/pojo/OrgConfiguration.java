package com.cn.hwyl.pojo;

import java.util.Date;

public class OrgConfiguration {
    private String cConfigid;

    private String cOrgid;

    private String cConfigtype;

    private String cServerip;

    private String cServerport;

    private String cUpdateuserid;

    private Date cUpdatetime;

    public String getcConfigid() {
        return cConfigid;
    }

    public void setcConfigid(String cConfigid) {
        this.cConfigid = cConfigid == null ? null : cConfigid.trim();
    }

    public String getcOrgid() {
        return cOrgid;
    }

    public void setcOrgid(String cOrgid) {
        this.cOrgid = cOrgid == null ? null : cOrgid.trim();
    }

    public String getcConfigtype() {
        return cConfigtype;
    }

    public void setcConfigtype(String cConfigtype) {
        this.cConfigtype = cConfigtype == null ? null : cConfigtype.trim();
    }

    public String getcServerip() {
        return cServerip;
    }

    public void setcServerip(String cServerip) {
        this.cServerip = cServerip == null ? null : cServerip.trim();
    }

    public String getcServerport() {
        return cServerport;
    }

    public void setcServerport(String cServerport) {
        this.cServerport = cServerport == null ? null : cServerport.trim();
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
		return "OrgConfiguration [cConfigid=" + cConfigid + ", cOrgid=" + cOrgid + ", cConfigtype=" + cConfigtype
				+ ", cServerip=" + cServerip + ", cServerport=" + cServerport + ", cUpdateuserid=" + cUpdateuserid
				+ ", cUpdatetime=" + cUpdatetime + "]";
	}
}