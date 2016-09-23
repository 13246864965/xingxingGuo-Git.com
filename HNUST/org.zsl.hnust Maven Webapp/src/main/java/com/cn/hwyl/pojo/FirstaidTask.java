package com.cn.hwyl.pojo;

import java.util.Date;

import com.cn.hwyl.pojo.request.PageInputContext;

public class FirstaidTask extends PageInputContext{
    private String cTaskid;

    private String cPatientsname;

    private String cPatientssex;

    private String cPatientsage;

    private String cPatientsphone;

    private Date cOnsettime;

    private String cOnsetaddress;

    private String cUrgentcontacts;

    private String cUrgentcontactsphone;

    private String cTaskproperties;

    private String cAmbulance;

    private String cTaskstate;

    private Date cUpdatetime;

    private String cUpdateuserid;

    private Date cCreatetime;

    private String cCreateuserid;

    private String cAmbulancenumber;
    private String cPatientscomplaint;

    private String cTasksummary;
    private int count;
    

    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getcPatientscomplaint() {
        return cPatientscomplaint;
    }

    public void setcPatientscomplaint(String cPatientscomplaint) {
        this.cPatientscomplaint = cPatientscomplaint == null ? null : cPatientscomplaint.trim();
    }

    public String getcTasksummary() {
        return cTasksummary;
    }

    public void setcTasksummary(String cTasksummary) {
        this.cTasksummary = cTasksummary == null ? null : cTasksummary.trim();
    }
    public String getcTaskid() {
        return cTaskid;
    }

    public void setcTaskid(String cTaskid) {
        this.cTaskid = cTaskid == null ? null : cTaskid.trim();
    }

    public String getcPatientsname() {
        return cPatientsname;
    }

    public void setcPatientsname(String cPatientsname) {
        this.cPatientsname = cPatientsname == null ? null : cPatientsname.trim();
    }

    public String getcPatientssex() {
        return cPatientssex;
    }

    public void setcPatientssex(String cPatientssex) {
        this.cPatientssex = cPatientssex == null ? null : cPatientssex.trim();
    }

    public String getcPatientsage() {
        return cPatientsage;
    }

    public void setcPatientsage(String cPatientsage) {
        this.cPatientsage = cPatientsage == null ? null : cPatientsage.trim();
    }

    public String getcPatientsphone() {
        return cPatientsphone;
    }

    public void setcPatientsphone(String cPatientsphone) {
        this.cPatientsphone = cPatientsphone == null ? null : cPatientsphone.trim();
    }

    public Date getcOnsettime() {
        return cOnsettime;
    }

    public void setcOnsettime(Date cOnsettime) {
        this.cOnsettime = cOnsettime;
    }

    public String getcOnsetaddress() {
        return cOnsetaddress;
    }

    public void setcOnsetaddress(String cOnsetaddress) {
        this.cOnsetaddress = cOnsetaddress == null ? null : cOnsetaddress.trim();
    }

    public String getcUrgentcontacts() {
        return cUrgentcontacts;
    }

    public void setcUrgentcontacts(String cUrgentcontacts) {
        this.cUrgentcontacts = cUrgentcontacts == null ? null : cUrgentcontacts.trim();
    }

    public String getcUrgentcontactsphone() {
        return cUrgentcontactsphone;
    }

    public void setcUrgentcontactsphone(String cUrgentcontactsphone) {
        this.cUrgentcontactsphone = cUrgentcontactsphone == null ? null : cUrgentcontactsphone.trim();
    }

    public String getcTaskproperties() {
        return cTaskproperties;
    }

    public void setcTaskproperties(String cTaskproperties) {
        this.cTaskproperties = cTaskproperties == null ? null : cTaskproperties.trim();
    }

    public String getcAmbulance() {
        return cAmbulance;
    }

    public void setcAmbulance(String cAmbulance) {
        this.cAmbulance = cAmbulance == null ? null : cAmbulance.trim();
    }

    public String getcTaskstate() {
        return cTaskstate;
    }

    public void setcTaskstate(String cTaskstate) {
        this.cTaskstate = cTaskstate == null ? null : cTaskstate.trim();
    }

    public Date getcUpdatetime() {
        return cUpdatetime;
    }

    public void setcUpdatetime(Date cUpdatetime) {
        this.cUpdatetime = cUpdatetime;
    }

    public String getcUpdateuserid() {
        return cUpdateuserid;
    }

    public void setcUpdateuserid(String cUpdateuserid) {
        this.cUpdateuserid = cUpdateuserid == null ? null : cUpdateuserid.trim();
    }

    public Date getcCreatetime() {
        return cCreatetime;
    }

    public void setcCreatetime(Date cCreatetime) {
        this.cCreatetime = cCreatetime;
    }

    public String getcCreateuserid() {
        return cCreateuserid;
    }

    public void setcCreateuserid(String cCreateuserid) {
        this.cCreateuserid = cCreateuserid == null ? null : cCreateuserid.trim();
    }

    public String getcAmbulancenumber() {
        return cAmbulancenumber;
    }

    public void setcAmbulancenumber(String cAmbulancenumber) {
        this.cAmbulancenumber = cAmbulancenumber == null ? null : cAmbulancenumber.trim();
    }

	@Override
	public String toString() {
		return "FirstaidTask [cTaskid=" + cTaskid + ", cPatientsname=" + cPatientsname + ", cPatientssex="
				+ cPatientssex + ", cPatientsage=" + cPatientsage + ", cPatientsphone=" + cPatientsphone
				+ ", cOnsettime=" + cOnsettime + ", cOnsetaddress=" + cOnsetaddress + ", cUrgentcontacts="
				+ cUrgentcontacts + ", cUrgentcontactsphone=" + cUrgentcontactsphone + ", cTaskproperties="
				+ cTaskproperties + ", cAmbulance=" + cAmbulance + ", cTaskstate=" + cTaskstate + ", cUpdatetime="
				+ cUpdatetime + ", cUpdateuserid=" + cUpdateuserid + ", cCreatetime=" + cCreatetime + ", cCreateuserid="
				+ cCreateuserid + ", cAmbulancenumber=" + cAmbulancenumber + ", cPatientscomplaint="
				+ cPatientscomplaint + ", cTasksummary=" + cTasksummary + "]";
	}
}