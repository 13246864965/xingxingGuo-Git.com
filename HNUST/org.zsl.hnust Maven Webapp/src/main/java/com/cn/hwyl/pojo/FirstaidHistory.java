package com.cn.hwyl.pojo;

import java.util.Date;

public class FirstaidHistory {
    private String cFirstaidid;

    private Date cFirstaidtime;

    private String cFirstaidstate;

    private String cDevicenumber;

    private String cCardnumber;

    private String cAmbulancenumber;

    private String cFirstaidupdatecode;

    private Date cFirstaidupdatetime;

    private String cOrgid;

    private Date cFirstaidendtime;

    private String cIscreatefirstaid;

    private String cAvdevicenumber;

    public String getcFirstaidid() {
        return cFirstaidid;
    }

    public void setcFirstaidid(String cFirstaidid) {
        this.cFirstaidid = cFirstaidid == null ? null : cFirstaidid.trim();
    }

    public Date getcFirstaidtime() {
        return cFirstaidtime;
    }

    public void setcFirstaidtime(Date cFirstaidtime) {
        this.cFirstaidtime = cFirstaidtime;
    }

    public String getcFirstaidstate() {
        return cFirstaidstate;
    }

    public void setcFirstaidstate(String cFirstaidstate) {
        this.cFirstaidstate = cFirstaidstate == null ? null : cFirstaidstate.trim();
    }

    public String getcDevicenumber() {
        return cDevicenumber;
    }

    public void setcDevicenumber(String cDevicenumber) {
        this.cDevicenumber = cDevicenumber == null ? null : cDevicenumber.trim();
    }

    public String getcCardnumber() {
        return cCardnumber;
    }

    public void setcCardnumber(String cCardnumber) {
        this.cCardnumber = cCardnumber == null ? null : cCardnumber.trim();
    }

    public String getcAmbulancenumber() {
        return cAmbulancenumber;
    }

    public void setcAmbulancenumber(String cAmbulancenumber) {
        this.cAmbulancenumber = cAmbulancenumber == null ? null : cAmbulancenumber.trim();
    }

    public String getcFirstaidupdatecode() {
        return cFirstaidupdatecode;
    }

    public void setcFirstaidupdatecode(String cFirstaidupdatecode) {
        this.cFirstaidupdatecode = cFirstaidupdatecode == null ? null : cFirstaidupdatecode.trim();
    }

    public Date getcFirstaidupdatetime() {
        return cFirstaidupdatetime;
    }

    public void setcFirstaidupdatetime(Date cFirstaidupdatetime) {
        this.cFirstaidupdatetime = cFirstaidupdatetime;
    }

    public String getcOrgid() {
        return cOrgid;
    }

    public void setcOrgid(String cOrgid) {
        this.cOrgid = cOrgid == null ? null : cOrgid.trim();
    }

    public Date getcFirstaidendtime() {
        return cFirstaidendtime;
    }

    public void setcFirstaidendtime(Date cFirstaidendtime) {
        this.cFirstaidendtime = cFirstaidendtime;
    }

    public String getcIscreatefirstaid() {
        return cIscreatefirstaid;
    }

    public void setcIscreatefirstaid(String cIscreatefirstaid) {
        this.cIscreatefirstaid = cIscreatefirstaid == null ? null : cIscreatefirstaid.trim();
    }

    public String getcAvdevicenumber() {
        return cAvdevicenumber;
    }

    public void setcAvdevicenumber(String cAvdevicenumber) {
        this.cAvdevicenumber = cAvdevicenumber == null ? null : cAvdevicenumber.trim();
    }

	@Override
	public String toString() {
		return "FirstaidHistory [cFirstaidid=" + cFirstaidid + ", cFirstaidtime=" + cFirstaidtime + ", cFirstaidstate="
				+ cFirstaidstate + ", cDevicenumber=" + cDevicenumber + ", cCardnumber=" + cCardnumber
				+ ", cAmbulancenumber=" + cAmbulancenumber + ", cFirstaidupdatecode=" + cFirstaidupdatecode
				+ ", cFirstaidupdatetime=" + cFirstaidupdatetime + ", cOrgid=" + cOrgid + ", cFirstaidendtime="
				+ cFirstaidendtime + ", cIscreatefirstaid=" + cIscreatefirstaid + ", cAvdevicenumber=" + cAvdevicenumber
				+ "]";
	}
}