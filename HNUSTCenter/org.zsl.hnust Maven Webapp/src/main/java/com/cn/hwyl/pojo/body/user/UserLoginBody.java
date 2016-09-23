package com.cn.hwyl.pojo.body.user;

import java.io.Serializable;

public class UserLoginBody implements Serializable{

	private static final long serialVersionUID = 3193108062638991676L;
	
	private String cUsername;

    private String cUserpwd;

	public String getcUsername() {
		return cUsername;
	}

	public void setcUsername(String cUsername) {
		this.cUsername = cUsername;
	}

	public String getcUserpwd() {
		return cUserpwd;
	}

	public void setcUserpwd(String cUserpwd) {
		this.cUserpwd = cUserpwd;
	}

	@Override
	public String toString() {
		return "UserLoginBody [cUsername=" + cUsername + ", cUserpwd=" + cUserpwd + "]";
	}
	
}
