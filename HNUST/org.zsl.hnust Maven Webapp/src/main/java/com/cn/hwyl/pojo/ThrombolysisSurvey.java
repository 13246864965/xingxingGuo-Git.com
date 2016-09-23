package com.cn.hwyl.pojo;

import java.util.Date;

public class ThrombolysisSurvey {
    private String cSurveyid;

    private String cFirstaidid;

    private String cUpdateuserid;

    private Date cUpdatetime;
    
    private String cSurveyinfo;

    private String cSurveyresults;

    private String cSurveynote;

    public String getcSurveyinfo() {
        return cSurveyinfo;
    }

    public void setcSurveyinfo(String cSurveyinfo) {
        this.cSurveyinfo = cSurveyinfo == null ? null : cSurveyinfo.trim();
    }

    public String getcSurveyresults() {
        return cSurveyresults;
    }

    public void setcSurveyresults(String cSurveyresults) {
        this.cSurveyresults = cSurveyresults == null ? null : cSurveyresults.trim();
    }

    public String getcSurveynote() {
        return cSurveynote;
    }

    public void setcSurveynote(String cSurveynote) {
        this.cSurveynote = cSurveynote == null ? null : cSurveynote.trim();
    }

    public String getcSurveyid() {
        return cSurveyid;
    }

    public void setcSurveyid(String cSurveyid) {
        this.cSurveyid = cSurveyid == null ? null : cSurveyid.trim();
    }

    public String getcFirstaidid() {
        return cFirstaidid;
    }

    public void setcFirstaidid(String cFirstaidid) {
        this.cFirstaidid = cFirstaidid == null ? null : cFirstaidid.trim();
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
		return "ThrombolysisSurvey [cSurveyid=" + cSurveyid + ", cFirstaidid=" + cFirstaidid + ", cUpdateuserid="
				+ cUpdateuserid + ", cUpdatetime=" + cUpdatetime + ", cSurveyinfo=" + cSurveyinfo + ", cSurveyresults="
				+ cSurveyresults + ", cSurveynote=" + cSurveynote + "]";
	}
}