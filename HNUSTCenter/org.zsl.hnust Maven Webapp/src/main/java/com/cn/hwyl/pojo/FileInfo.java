package com.cn.hwyl.pojo;

public class FileInfo {
    private String cFilename;

    private String cFileid;

    private String cFilepath;

    private String cFilesize;

    private String cFiletype;

    private String cIsdelete;

    private String cFileforeign;
	private int count;
    
    private String fileDownloadUrl;
    
    private String cOrgId;
    
    public String getcOrgId() {
		return cOrgId;
	}

	public void setcOrgId(String cOrgId) {
		this.cOrgId = cOrgId;
	}

	public String getFileDownloadUrl() {
		return fileDownloadUrl;
	}

	public void setFileDownloadUrl(String fileDownloadUrl) {
		this.fileDownloadUrl = fileDownloadUrl;
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
}