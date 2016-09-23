package com.cn.hwyl.pojo.body.user;

import com.cn.hwyl.pojo.User;
import com.cn.hwyl.pojo.UserRole;

public class UserEditBody {

	private User user;
	private UserRole userRole;
	
	

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
