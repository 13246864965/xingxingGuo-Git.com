package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.User;

@Repository
public interface IUserDao {
    int deleteByPrimaryKey(String cUserid);

    int insert(User record);
    int saveOrUpdate(User record);
    int insertSelective(User record);

    User selectByPrimaryKey(String cUserid);
    
    User selectByCusername(String cUsername);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectByPage(User user);
    
    int selectByPageCount(User user);
}