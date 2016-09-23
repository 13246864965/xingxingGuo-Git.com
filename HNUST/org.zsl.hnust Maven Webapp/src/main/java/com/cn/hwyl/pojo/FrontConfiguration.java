package com.cn.hwyl.pojo;

import java.util.Date;

public class FrontConfiguration {
    private String cOrgid;

    private String cOrgcode;

    private String cSocketaddress;

    private String cWsdladdress;

    private String cServeraddress;

    private String cDescribe;

    private String cUpdateuserid;

    private Date cUpdatetime;
    
    private String cAVOutAddress;

    
    public String getcAVOutAddress() {
		return cAVOutAddress;
	}

	public void setcAVOutAddress(String cAVOutAddress) {
		this.cAVOutAddress = cAVOutAddress;
	}

	public String getcOrgid() {
        return cOrgid;
    }

    public void setcOrgid(String cOrgid) {
        this.cOrgid = cOrgid == null ? null : cOrgid.trim();
    }

    public String getcOrgcode() {
        return cOrgcode;
    }

    public void setcOrgcode(String cOrgcode) {
        this.cOrgcode = cOrgcode == null ? null : cOrgcode.trim();
    }

    public String getcSocketaddress() {
        return cSocketaddress;
    }

    public void setcSocketaddress(String cSocketaddress) {
        this.cSocketaddress = cSocketaddress == null ? null : cSocketaddress.trim();
    }

    public String getcWsdladdress() {
        return cWsdladdress;
    }

    public void setcWsdladdress(String cWsdladdress) {
        this.cWsdladdress = cWsdladdress == null ? null : cWsdladdress.trim();
    }

    public String getcServeraddress() {
        return cServeraddress;
    }

    public void setcServeraddress(String cServeraddress) {
        this.cServeraddress = cServeraddress == null ? null : cServeraddress.trim();
    }

    public String getcDescribe() {
        return cDescribe;
    }

    public void setcDescribe(String cDescribe) {
        this.cDescribe = cDescribe == null ? null : cDescribe.trim();
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
		return "FrontConfiguration [cOrgid=" + cOrgid + ", cOrgcode=" + cOrgcode + ", cSocketaddress=" + cSocketaddress
				+ ", cWsdladdress=" + cWsdladdress + ", cServeraddress=" + cServeraddress + ", cDescribe=" + cDescribe
				+ ", cUpdateuserid=" + cUpdateuserid + ", cUpdatetime=" + cUpdatetime + "]";
	}
}