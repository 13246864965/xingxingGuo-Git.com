package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.User;

public interface IUserService {

	int deleteByPrimaryKey(String cUserid);

	int insert(User record);

	int saveOrUpdate(User record);

	User selectByPrimaryKey(String cUserid);

	User selectByCusername(String cUsername);

	List<User> selectByPage(User user);

	int selectByPageCount(User user);

	int updateByPrimaryKey(User record);

	User selectByUsername(String username);
}
