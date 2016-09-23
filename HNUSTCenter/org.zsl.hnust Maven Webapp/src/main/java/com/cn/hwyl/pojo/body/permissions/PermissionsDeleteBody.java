package com.cn.hwyl.pojo.body.permissions;

public class PermissionsDeleteBody {
	
	private String	cPrivilegeID;

	public String getcPrivilegeID() {
		return cPrivilegeID;
	}

	public void setcPrivilegeID(String cPrivilegeID) {
		this.cPrivilegeID = cPrivilegeID;
	}

	@Override
	public String toString() {
		return "PermissionsDeleteBody [cPrivilegeID=" + cPrivilegeID + "]";
	}

}
