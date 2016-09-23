package com.cn.hwyl.service.impl;

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
	public int insertSelective(FileInfo record) {
		return fileDao.insert(record);
	}

	@Override
	public FileInfo selectByFile(FileInfo record) {
		return fileDao.selectByFile(record);
	}

	@Override
	public int saveOrUpdate(FileInfo record) {
		return fileDao.saveOrUpdate(record);
	}

}
