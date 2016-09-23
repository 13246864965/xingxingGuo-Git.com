package com.cn.hwyl.service;

import com.cn.hwyl.pojo.OrgConfiguration;
import com.cn.hwyl.pojo.response.Result;

public interface IOrgConfigurationService {

    int deleteByPrimaryKey(String cConfigid);

    int insert(OrgConfiguration record);

    int insertSelective(OrgConfiguration record);

    OrgConfiguration selectByPrimaryKey(String cConfigid);

    int updateByPrimaryKeySelective(OrgConfiguration record);

    int updateByPrimaryKey(OrgConfiguration record);
    
   Result insertOrgAndsyncFranc(OrgConfiguration record);

}
