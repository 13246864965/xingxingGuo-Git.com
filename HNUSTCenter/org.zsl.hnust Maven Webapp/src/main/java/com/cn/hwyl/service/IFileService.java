package com.cn.hwyl.service;

import com.cn.hwyl.pojo.FileInfo;

public interface IFileService {
    int insert(FileInfo record);
    int saveOrUpdate(FileInfo record);

    int insertSelective(FileInfo record);
    
    FileInfo selectByFile(FileInfo record);
}