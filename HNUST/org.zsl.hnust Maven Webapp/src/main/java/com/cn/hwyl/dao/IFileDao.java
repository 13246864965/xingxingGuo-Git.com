package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FileInfo;

@Repository
public interface IFileDao {
    int insert(FileInfo record);
    int saveOrUpdate(FileInfo record);

    List<FileInfo> selectByFile(FileInfo record);
    //查询映像
    List<FileInfo> selectByFileImg(FileInfo record);
    
}