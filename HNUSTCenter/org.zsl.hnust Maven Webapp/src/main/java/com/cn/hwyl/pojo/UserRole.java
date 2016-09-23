package com.cn.hwyl.pojo;

import java.util.Date;

public class UserRole {
    private String cUserroleid;

    private String cUserid;

    private String cRoleid;

    private String cUpdateuserid;

    private Date cDatetime;

    public String getcUserroleid() {
        return cUserroleid;
    }

    public void setcUserroleid(String cUserroleid) {
        this.cUserroleid = cUserroleid == null ? null : cUserroleid.trim();
    }

    public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid == null ? null : cUserid.trim();
    }

    public String getcRoleid() {
        return cRoleid;
    }

    public void setcRoleid(String cRoleid) {
        this.cRoleid = cRoleid == null ? null : cRoleid.trim();
    }

    public String getcUpdateuserid() {
        return cUpdateuserid;
    }

    public void setcUpdateuserid(String cUpdateuserid) {
        this.cUpdateuserid = cUpdateuserid == null ? null : cUpdateuserid.trim();
    }

    public Date getcDatetime() {
        return cDatetime;
    }

    public void setcDatetime(Date cDatetime) {
        this.cDatetime = cDatetime;
    }
}