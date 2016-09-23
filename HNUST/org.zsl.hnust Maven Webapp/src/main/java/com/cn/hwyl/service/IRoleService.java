package com.cn.hwyl.service;

import java.util.List;
import java.util.Map;

import com.cn.hwyl.pojo.Role;
import com.cn.hwyl.pojo.response.Result;

public interface IRoleService {

    int deleteByPrimaryKey(String cRoleid);

    int insert(Role record);

    Role selectByPrimaryKey(String cRoleid);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectByPage(Role record);
    
    int selectByCount(Role record);
    
//    Result inserRoleAndOrganize(HospitalServiceCenter record);
    Result inserRoleAndOrganize(Map<String,Object> record);

}
