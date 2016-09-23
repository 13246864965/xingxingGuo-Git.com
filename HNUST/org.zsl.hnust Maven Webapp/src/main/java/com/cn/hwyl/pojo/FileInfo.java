package com.cn.hwyl.pojo;

import java.util.Date;

public class FileInfo {
    private String cFilename;

    private String cFileid;

    private String cFilepath;

    private String cFilesize;

    private String cFiletype;

    private String cIsdelete;

    private String cFileforeign;

    private int count;
    
    private String cOrgId;
    
    private String cType;
    
    private String cFileImg;
    
    private String cUpdateUserID;
    private Date cUpdateTime;
    
    private String cImageType;
    
    public String getcImageType() {
		return cImageType;
	}

	public void setcImageType(String cImageType) {
		this.cImageType = cImageType;
	}

	public String getcUpdateUserID() {
		return cUpdateUserID;
	}

	public void setcUpdateUserID(String cUpdateUserID) {
		this.cUpdateUserID = cUpdateUserID;
	}

	public Date getcUpdateTime() {
		return cUpdateTime;
	}

	public void setcUpdateTime(Date cUpdateTime) {
		this.cUpdateTime = cUpdateTime;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcFileImg() {
		return cFileImg;
	}

	public void setcFileImg(String cFileImg) {
		this.cFileImg = cFileImg;
	}

	public String getcOrgId() {
		return cOrgId;
	}

	public void setcOrgId(String cOrgId) {
		this.cOrgId = cOrgId;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getcFilename() {
        return cFilename;
    }

    public void setcFilename(String cFilename) {
        this.cFilename = cFilename == null ? null : cFilename.trim();
    }

    public String getcFileid() {
        return cFileid;
    }

    public void setcFileid(String cFileid) {
        this.cFileid = cFileid == null ? null : cFileid.trim();
    }

    public String getcFilepath() {
        return cFilepath;
    }

    public void setcFilepath(String cFilepath) {
        this.cFilepath = cFilepath == null ? null : cFilepath.trim();
    }

    public String getcFilesize() {
        return cFilesize;
    }

    public void setcFilesize(String cFilesize) {
        this.cFilesize = cFilesize == null ? null : cFilesize.trim();
    }

    public String getcFiletype() {
        return cFiletype;
    }

    public void setcFiletype(String cFiletype) {
        this.cFiletype = cFiletype == null ? null : cFiletype.trim();
    }

    public String getcIsdelete() {
        return cIsdelete;
    }

    public void setcIsdelete(String cIsdelete) {
        this.cIsdelete = cIsdelete == null ? null : cIsdelete.trim();
    }

    public String getcFileforeign() {
        return cFileforeign;
    }

    public void setcFileforeign(String cFileforeign) {
        this.cFileforeign = cFileforeign == null ? null : cFileforeign.trim();
    }

	@Override
	public String toString() {
		return "FileInfo [cFilename=" + cFilename + ", cFileid=" + cFileid + ", cFilepath=" + cFilepath + ", cFilesize="
				+ cFilesize + ", cFiletype=" + cFiletype + ", cIsdelete=" + cIsdelete + ", cFileforeign=" + cFileforeign
				+ ", count=" + count + ", cOrgId=" + cOrgId + ", cType=" + cType + ", cFileImg=" + cFileImg
				+ ", cUpdateUserID=" + cUpdateUserID + ", cUpdateTime=" + cUpdateTime + ", cImageType=" + cImageType
				+ "]";
	}
}