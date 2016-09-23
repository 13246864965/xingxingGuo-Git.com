package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FileInfo;

@Repository
public interface IFileDao {
    int insert(FileInfo record);
    int saveOrUpdate(FileInfo record);

    int insertSelective(FileInfo record);
    
    FileInfo selectByFile(FileInfo record);
    
}