package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IFileDao;
import com.cn.hwyl.pojo.FileInfo;
import com.cn.hwyl.service.IFileService;

@Service("fileService")
public class FileServiceImpl implements IFileService
{

	
	@Resource
	private IFileDao fileDao;
	@Override
	public int insert(FileInfo record) {
		return fileDao.insert(record);
	}


	@Override
	public List<FileInfo> selectByFile(FileInfo record) {
		return fileDao.selectByFile(record);
	}

	@Override
	public int saveOrUpdate(FileInfo record) {
		return fileDao.saveOrUpdate(record);
	}

	@Override
	public List<FileInfo> selectByFileImg(FileInfo record) {
		return fileDao.selectByFileImg(record);
	}

}
