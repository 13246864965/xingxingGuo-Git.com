package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hwyl.dao.IFirstAidDao;
import com.cn.hwyl.dao.IFirstAidInfoDao;
import com.cn.hwyl.dao.IFirstaidHistoryDao;
import com.cn.hwyl.dao.IFirstaidResultsDao;
import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.FirstaidResults;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFirstaidResultsService;

@Transactional(rollbackFor = { RuntimeException.class })
@Service("firstaidResultsService")
public class FirstaidResultsServiceImpl implements IFirstaidResultsService {
	private Logger logger = Logger.getLogger(FirstaidResultsServiceImpl.class);
	@Resource
	private IFirstaidResultsDao firstaidResultsDao;
	@Resource
	private IFirstaidHistoryDao firstaidHistoryDao;
	@Resource
	private IFirstAidInfoDao firstAidInfoDao;
	@Resource
	private IFirstAidDao firstAidDao;

	@Override
	public int deleteByPrimaryKey(String cResultsid) {
		return firstaidResultsDao.deleteByPrimaryKey(cResultsid);
	}

	@Override
	public int insert(FirstaidResults record) {
		return firstaidResultsDao.insert(record);
	}

	@Override
	public FirstaidResults selectByPrimaryKey(String cResultsid) {
		return firstaidResultsDao.selectByPrimaryKey(cResultsid);
	}

	@Override
	public int updateByPrimaryKey(FirstaidResults record) {
		return firstaidResultsDao.updateByPrimaryKey(record);
	}

	@Override
	public Result saveOrUpdateResultsBody(BodyRequest body) {
		Result result = new Result();
		try {
			// 1,当firstAidStatus为123变动的时候，更新firstAid
			// if (body.getFirstAidResultsBody().getFirstAid() != null) {
			// if
			// ("54".contains(body.getFirstAidResultsBody().getFirstAid().getcFirstaidstate()))
			// {
			// } else {
			//
			// }
			//
			//
			// logger.info("saveOrUpdateResultsBody firstAid successfule!!"+
			// body.getFirstAidResultsBody().getFirstAid().toString());
			// }
			// 1,当firstAidStatus为123变动的时候，更新firstAid
			String firstAidState = body.getFirstAidResultsBody().getFirstaidResults().getcResultstype().toString();
			String cFirstaidid = body.getFirstAidResultsBody().getFirstaidResults().getcFirstaidid();
			FirstAid firstAid = new FirstAid();
			firstAid.setcFirstaidid(cFirstaidid);
			firstAid.setcFirstaidstate(firstAidState);

			firstAidDao.saveOrUpdate(firstAid);

			if ("5".equals(firstAidState) || "4".equals(firstAidState)) {
				// 添加firstAidHistory ，删除 firstAid
				firstAidInfoDao.insertByFirstAidID(cFirstaidid);
				firstAidDao.deleteByPrimaryKey(cFirstaidid);
			}

			// // 2, firstAidState 由3变位4或者5 更新FirstAidHistory
			// if (body.getFirstAidResultsBody().getFirstaidHistory() != null) {
			// firstaidHistoryDao.insert(body.getFirstAidResultsBody().getFirstaidHistory());
			// logger.info("saveOrUpdateResultsBody firstaidHistory
			// successfule!!"
			// + body.getFirstAidResultsBody().getFirstaidHistory().toString());
			// }
			// 更新记录到FirstAidResults
			if (body.getFirstAidResultsBody().getFirstaidResults() != null) {
				firstaidResultsDao.insert(body.getFirstAidResultsBody().getFirstaidResults());
				logger.info("saveOrUpdateResultsBody firstaidHistory successfule!!"
						+ body.getFirstAidResultsBody().getFirstaidResults().toString());
			}
			result.setResultCode("1");
			result.setErrorInfo("急救档案操作成功！！");
		} catch (Exception e) {
			result.setResultCode("0");
			result.setErrorInfo("急救档案操作失败！！" + e.getMessage());
			logger.error("saveOrUpdateResultsBody faild" + e);
			throw new RuntimeException(e);
		}
		return result;

	}

	@Override
	public List<FirstaidResults> selectByPage(FirstaidResults record) {
		return firstaidResultsDao.selectByPage(record);
	}

	@Override
	public int selectByPageCount(FirstaidResults record) {
		return firstaidResultsDao.selectByPageCount(record);
	}

}
