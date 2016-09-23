package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.FileInfo;

public interface IFileService {
	int insert(FileInfo record);

	int saveOrUpdate(FileInfo record);

	List<FileInfo> selectByFile(FileInfo record);

	List<FileInfo> selectByFileImg(FileInfo record);
}