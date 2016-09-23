package com.cn.hwyl.pojo;

import java.util.Date;

import com.cn.hwyl.pojo.request.PageInputContext;

public class FollowUpVisits extends PageInputContext{
    private Integer cVisitsid;

    private String cPatientsid;

    private String cFirstaidid;

    private Date cLeavehospitaltime;

    private String cDiagnosisofchestpain;

    private Integer cVisitsnumber;

    private String cClinicalmanifestation;

    private String cDiagnosticopinion;

    private Date cVisitstime;

    private String cState;
    private int count;
    
//患者信息
    
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
	
	private String cLabelNo;
    
    
	
    public String getcPatientsname() {
		return cPatientsname;
	}

	public void setcPatientsname(String cPatientsname) {
		this.cPatientsname = cPatientsname;
	}

	public String getcPatientssex() {
		return cPatientssex;
	}

	public void setcPatientssex(String cPatientssex) {
		this.cPatientssex = cPatientssex;
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
		this.cPatientsphonenumber = cPatientsphonenumber;
	}

	public String getcPatientsemergencycontact() {
		return cPatientsemergencycontact;
	}

	public void setcPatientsemergencycontact(String cPatientsemergencycontact) {
		this.cPatientsemergencycontact = cPatientsemergencycontact;
	}

	public String getcPatientsemergencyphonenumber() {
		return cPatientsemergencyphonenumber;
	}

	public void setcPatientsemergencyphonenumber(String cPatientsemergencyphonenumber) {
		this.cPatientsemergencyphonenumber = cPatientsemergencyphonenumber;
	}

	public String getcOutpatientserviceid() {
		return cOutpatientserviceid;
	}

	public void setcOutpatientserviceid(String cOutpatientserviceid) {
		this.cOutpatientserviceid = cOutpatientserviceid;
	}

	public String getcHospitalid() {
		return cHospitalid;
	}

	public void setcHospitalid(String cHospitalid) {
		this.cHospitalid = cHospitalid;
	}

	public String getcOnsetaddress() {
		return cOnsetaddress;
	}

	public void setcOnsetaddress(String cOnsetaddress) {
		this.cOnsetaddress = cOnsetaddress;
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
		this.cIssend = cIssend;
	}

	public String getcUpdateuserid() {
		return cUpdateuserid;
	}

	public void setcUpdateuserid(String cUpdateuserid) {
		this.cUpdateuserid = cUpdateuserid;
	}

	public Date getcUpdatetime() {
		return cUpdatetime;
	}

	public void setcUpdatetime(Date cUpdatetime) {
		this.cUpdatetime = cUpdatetime;
	}

	public String getcIDNmber() {
		return cIDNmber;
	}

	public void setcIDNmber(String cIDNmber) {
		this.cIDNmber = cIDNmber;
	}

	public String getcLabelNo() {
		return cLabelNo;
	}

	public void setcLabelNo(String cLabelNo) {
		this.cLabelNo = cLabelNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Integer getcVisitsid() {
        return cVisitsid;
    }

    public void setcVisitsid(Integer cVisitsid) {
        this.cVisitsid = cVisitsid;
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

    public Date getcLeavehospitaltime() {
        return cLeavehospitaltime;
    }

    public void setcLeavehospitaltime(Date cLeavehospitaltime) {
        this.cLeavehospitaltime = cLeavehospitaltime;
    }

    public String getcDiagnosisofchestpain() {
        return cDiagnosisofchestpain;
    }

    public void setcDiagnosisofchestpain(String cDiagnosisofchestpain) {
        this.cDiagnosisofchestpain = cDiagnosisofchestpain == null ? null : cDiagnosisofchestpain.trim();
    }

    public Integer getcVisitsnumber() {
        return cVisitsnumber;
    }

    public void setcVisitsnumber(Integer cVisitsnumber) {
        this.cVisitsnumber = cVisitsnumber;
    }

    public String getcClinicalmanifestation() {
        return cClinicalmanifestation;
    }

    public void setcClinicalmanifestation(String cClinicalmanifestation) {
        this.cClinicalmanifestation = cClinicalmanifestation == null ? null : cClinicalmanifestation.trim();
    }

    public String getcDiagnosticopinion() {
        return cDiagnosticopinion;
    }

    public void setcDiagnosticopinion(String cDiagnosticopinion) {
        this.cDiagnosticopinion = cDiagnosticopinion == null ? null : cDiagnosticopinion.trim();
    }

    public Date getcVisitstime() {
        return cVisitstime;
    }

    public void setcVisitstime(Date cVisitstime) {
        this.cVisitstime = cVisitstime;
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState == null ? null : cState.trim();
    }

	@Override
	public String toString() {
		return "FollowUpVisits [cVisitsid=" + cVisitsid + ", cPatientsid=" + cPatientsid + ", cFirstaidid="
				+ cFirstaidid + ", cLeavehospitaltime=" + cLeavehospitaltime + ", cDiagnosisofchestpain="
				+ cDiagnosisofchestpain + ", cVisitsnumber=" + cVisitsnumber + ", cClinicalmanifestation="
				+ cClinicalmanifestation + ", cDiagnosticopinion=" + cDiagnosticopinion + ", cVisitstime=" + cVisitstime
				+ ", cState=" + cState + ", count=" + count + ", cPatientsname=" + cPatientsname + ", cPatientssex="
				+ cPatientssex + ", cPatientsage=" + cPatientsage + ", cPatientsbirthday=" + cPatientsbirthday
				+ ", cPatientsphonenumber=" + cPatientsphonenumber + ", cPatientsemergencycontact="
				+ cPatientsemergencycontact + ", cPatientsemergencyphonenumber=" + cPatientsemergencyphonenumber
				+ ", cOutpatientserviceid=" + cOutpatientserviceid + ", cHospitalid=" + cHospitalid + ", cOnsetaddress="
				+ cOnsetaddress + ", cOnsettime=" + cOnsettime + ", cIssend=" + cIssend + ", cUpdateuserid="
				+ cUpdateuserid + ", cUpdatetime=" + cUpdatetime + ", cIDNmber=" + cIDNmber + ", cLabelNo=" + cLabelNo
				+ "]";
	}
}