package com.cn.hwyl.pojo;

import java.util.Date;

import com.cn.hwyl.pojo.request.PageInputContext;

public class User extends PageInputContext{
	
    private String cUserid;

    private String cUsercode;

    private String cUsername;

    private String cUserpwd;

    private String cUsersex;

    private Integer cUserage;

    private String cUpdateuserid;

    private Date cUpdatetime;

    private String cOrgid;

    private String cUsertype;

    private String cUserstate;

    private String cUsertruename;

    private String cUserjob;

    private String cUserphone;

    private String cUseremail;
   
    private int count;
   
    

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid == null ? null : cUserid.trim();
    }

    public String getcUsercode() {
        return cUsercode;
    }

    public void setcUsercode(String cUsercode) {
        this.cUsercode = cUsercode == null ? null : cUsercode.trim();
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername == null ? null : cUsername.trim();
    }

    public String getcUserpwd() {
        return cUserpwd;
    }

    public void setcUserpwd(String cUserpwd) {
        this.cUserpwd = cUserpwd == null ? null : cUserpwd.trim();
    }

    public String getcUsersex() {
        return cUsersex;
    }

    public void setcUsersex(String cUsersex) {
        this.cUsersex = cUsersex == null ? null : cUsersex.trim();
    }

    public Integer getcUserage() {
        return cUserage;
    }

    public void setcUserage(Integer cUserage) {
        this.cUserage = cUserage;
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

    public String getcOrgid() {
        return cOrgid;
    }

    public void setcOrgid(String cOrgid) {
        this.cOrgid = cOrgid == null ? null : cOrgid.trim();
    }

    public String getcUsertype() {
        return cUsertype;
    }

    public void setcUsertype(String cUsertype) {
        this.cUsertype = cUsertype == null ? null : cUsertype.trim();
    }

    public String getcUserstate() {
        return cUserstate;
    }

    public void setcUserstate(String cUserstate) {
        this.cUserstate = cUserstate == null ? null : cUserstate.trim();
    }

    public String getcUsertruename() {
        return cUsertruename;
    }

    public void setcUsertruename(String cUsertruename) {
        this.cUsertruename = cUsertruename == null ? null : cUsertruename.trim();
    }

    public String getcUserjob() {
        return cUserjob;
    }

    public void setcUserjob(String cUserjob) {
        this.cUserjob = cUserjob == null ? null : cUserjob.trim();
    }

    public String getcUserphone() {
        return cUserphone;
    }

    public void setcUserphone(String cUserphone) {
        this.cUserphone = cUserphone == null ? null : cUserphone.trim();
    }

    public String getcUseremail() {
        return cUseremail;
    }

    public void setcUseremail(String cUseremail) {
        this.cUseremail = cUseremail == null ? null : cUseremail.trim();
    }

	@Override
	public String toString() {
		return "User [cUserid=" + cUserid + ", cUsercode=" + cUsercode + ", cUsername=" + cUsername + ", cUserpwd="
				+ cUserpwd + ", cUsersex=" + cUsersex + ", cUserage=" + cUserage + ", cUpdateuserid=" + cUpdateuserid
				+ ", cUpdatetime=" + cUpdatetime + ", cOrgid=" + cOrgid + ", cUsertype=" + cUsertype + ", cUserstate="
				+ cUserstate + ", cUsertruename=" + cUsertruename + ", cUserjob=" + cUserjob + ", cUserphone="
				+ cUserphone + ", cUseremail=" + cUseremail + "]";
	}
    
    
}