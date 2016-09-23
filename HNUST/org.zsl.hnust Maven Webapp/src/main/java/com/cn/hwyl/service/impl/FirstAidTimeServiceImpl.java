package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hwyl.dao.IFirstAidTimeDao;
import com.cn.hwyl.pojo.FirstAidTime;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFirstAidTimeService;

@Transactional(rollbackFor = {RuntimeException.class})
@Service("firstAidTimeService")
public class FirstAidTimeServiceImpl implements IFirstAidTimeService{
	private static Logger logger = Logger.getLogger(FirstAidTimeServiceImpl.class);
	
	@Resource
	private IFirstAidTimeDao firstAidTimeDao;
	@Override
	public int deleteByPrimaryKey(String cTimeid) {
		return firstAidTimeDao.deleteByPrimaryKey(cTimeid);
	}

	@Override
	public int insert(FirstAidTime record) {
		return firstAidTimeDao.insert(record);
	}


	@Override
	public FirstAidTime selectByPrimaryKey(String cTimeid) {
		return firstAidTimeDao.selectByPrimaryKey(cTimeid);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(FirstAidTime record) {
		return firstAidTimeDao.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(FirstAidTime record) {
		return firstAidTimeDao.updateByPrimaryKey(record);
	}

	@Override
	public int saveOrUpdate(FirstAidTime record) {
		return firstAidTimeDao.saveOrUpdate(record);
	}

	@Override
	public Result insertBatchAndDelete(List<FirstAidTime> record) {
		for (int i = 0; i < record.size(); i++) {
			logger.info("insertBatchAndDelete param[       "+i+"    ]"
					+record.get(i).toString());
		}
		Result result = new Result();
		try {
			//1，根据传过来的时间删除数据
			firstAidTimeDao.deleteBatch(record);
			//2,在添加新的数据
			firstAidTimeDao.insertBatch(record);
			result.setResultCode("1");
			result.setErrorInfo("操作成功");
		} catch (Exception e) {
			logger.error("保存时间失败！！"+e);
			result.setErrorCode("0");
			result.setErrorInfo("保存时间失败");
			throw new RuntimeException(e);
		}
		
		return result;
	}

	@Override
	public List<FirstAidTime> selectByPrimaryByFirstAidTime(FirstAidTime record) {
		return firstAidTimeDao.selectByPrimaryByFirstAidTime(record);
	}


}
