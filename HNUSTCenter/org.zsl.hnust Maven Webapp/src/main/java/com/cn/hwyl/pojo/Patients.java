package com.cn.hwyl.pojo;

import java.util.Date;

public class Patients {
    private String cPatientsid;

    private String cFirstaidid;

    private String cPatientsname;

    private String cPatientssex;

    private Integer cPatientsage;

    private Date cPatientsbirthday;

    private String cPatientsphonenumber;

    private String cPatientsemergencycontact;

    private String cPatientsemergencyphonenumber;

    private String cOutpatientserviceid;

    private String cHospitalid;

    private String cOnsetaddress;

    private Date cOnsettime;

    private String cIssend;

    private String cUpdateuserid;

    private Date cUpdatetime;
    
	private String cIDNmber;

	private int count;

	public String getcIDNmber() {
		return cIDNmber;
	}

	public void setcIDNmber(String cIDNmber) {
		this.cIDNmber = cIDNmber;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

    public String getcPatientsid() {
        return cPatientsid;
    }

    public void setcPatientsid(String cPatientsid) {
        this.cPatientsid = cPatientsid == null ? null : cPatientsid.trim();
    }

    public String getcFirstaidid() {
        return cFirstaidid;
    }

    public void setcFirstaidid(String cFirstaidid) {
        this.cFirstaidid = cFirstaidid == null ? null : cFirstaidid.trim();
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

    public Integer getcPatientsage() {
        return cPatientsage;
    }

    public void setcPatientsage(Integer cPatientsage) {
        this.cPatientsage = cPatientsage;
    }

    public Date getcPatientsbirthday() {
        return cPatientsbirthday;
    }

    public void setcPatientsbirthday(Date cPatientsbirthday) {
        this.cPatientsbirthday = cPatientsbirthday;
    }

    public String getcPatientsphonenumber() {
        return cPatientsphonenumber;
    }

    public void setcPatientsphonenumber(String cPatientsphonenumber) {
        this.cPatientsphonenumber = cPatientsphonenumber == null ? null : cPatientsphonenumber.trim();
    }

    public String getcPatientsemergencycontact() {
        return cPatientsemergencycontact;
    }

    public void setcPatientsemergencycontact(String cPatientsemergencycontact) {
        this.cPatientsemergencycontact = cPatientsemergencycontact == null ? null : cPatientsemergencycontact.trim();
    }

    public String getcPatientsemergencyphonenumber() {
        return cPatientsemergencyphonenumber;
    }

    public void setcPatientsemergencyphonenumber(String cPatientsemergencyphonenumber) {
        this.cPatientsemergencyphonenumber = cPatientsemergencyphonenumber == null ? null : cPatientsemergencyphonenumber.trim();
    }

    public String getcOutpatientserviceid() {
        return cOutpatientserviceid;
    }

    public void setcOutpatientserviceid(String cOutpatientserviceid) {
        this.cOutpatientserviceid = cOutpatientserviceid == null ? null : cOutpatientserviceid.trim();
    }

    public String getcHospitalid() {
        return cHospitalid;
    }

    public void setcHospitalid(String cHospitalid) {
        this.cHospitalid = cHospitalid == null ? null : cHospitalid.trim();
    }

    public String getcOnsetaddress() {
        return cOnsetaddress;
    }

    public void setcOnsetaddress(String cOnsetaddress) {
        this.cOnsetaddress = cOnsetaddress == null ? null : cOnsetaddress.trim();
    }

    public Date getcOnsettime() {
        return cOnsettime;
    }

    public void setcOnsettime(Date cOnsettime) {
        this.cOnsettime = cOnsettime;
    }

    public String getcIssend() {
        return cIssend;
    }

    public void setcIssend(String cIssend) {
        this.cIssend = cIssend == null ? null : cIssend.trim();
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
		return "Patients [cPatientsid=" + cPatientsid + ", cFirstaidid=" + cFirstaidid + ", cPatientsname="
				+ cPatientsname + ", cPatientssex=" + cPatientssex + ", cPatientsage=" + cPatientsage
				+ ", cPatientsbirthday=" + cPatientsbirthday + ", cPatientsphonenumber=" + cPatientsphonenumber
				+ ", cPatientsemergencycontact=" + cPatientsemergencycontact + ", cPatientsemergencyphonenumber="
				+ cPatientsemergencyphonenumber + ", cOutpatientserviceid=" + cOutpatientserviceid + ", cHospitalid="
				+ cHospitalid + ", cOnsetaddress=" + cOnsetaddress + ", cOnsettime=" + cOnsettime + ", cIssend="
				+ cIssend + ", cUpdateuserid=" + cUpdateuserid + ", cUpdatetime=" + cUpdatetime + "]";
	}
}