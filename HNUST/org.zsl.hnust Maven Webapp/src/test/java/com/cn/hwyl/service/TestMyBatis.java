package com.cn.hwyl.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hwyl.dao.IFirstAidInfoDao;
import com.cn.hwyl.dao.IFirstaidCollectionDao;
import com.cn.hwyl.dao.IFirstaidHistoryDao;
import com.cn.hwyl.pojo.AmbulanceDevice;
import com.cn.hwyl.pojo.DeviceUpdate;
import com.cn.hwyl.pojo.FileInfo;
import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.FirstAidInfo;
import com.cn.hwyl.pojo.FirstAidInfoView;
import com.cn.hwyl.pojo.FirstAidTime;
import com.cn.hwyl.pojo.FirstaidCollection;
import com.cn.hwyl.pojo.FirstaidResults;
import com.cn.hwyl.pojo.FirstaidTask;
import com.cn.hwyl.pojo.FollowUpVisits;
import com.cn.hwyl.pojo.Organization;
import com.cn.hwyl.pojo.ThrombolysisSurvey;
import com.cn.hwyl.pojo.User;
//import com.google.gson.Gson;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
// @Transactional //是否回滚
// @Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	// private ApplicationContext ac = null;
	@Autowired
	private IUserService userService;
	@Resource
	private IFirstAidService firstAidService;
	@Resource
	private IFirstAidInfoDao firstAidInfoDao;
	@Resource
	private IFirstAidInfoService firstAidInfoService;
	@Resource
	private IOrganizationService organizationService;
	@Resource
	IAmbulanceDeviceService ambulanceDeviceService;
	@Resource
	private IFirstAidTimeService firstAidTimeService;
	@Resource
	private IFirstAidInfoViewService firstAidInfoViewService;
	@Resource
	private IFileService fileService;
	@Resource
	private IFrontConfigurationService frontConfigurationService;
	@Resource
	private IThrombolysisSurveyService thrombolysisSurveyService;
	@Resource
	private IFirstaidCollectionDao firstaidCollectionDao;
	@Resource
	private IFirstaidHistoryDao firstaidHistoryDao;
	@Resource
	private IFollowUpVisitsService followUpVisitsService;
	@Resource
	private IFirstaidTaskService firstaidTaskService;
	@Resource
	private IFirstaidResultsService firstaidResultsService;
	@Resource
	private IDeviceUpdateService deviceUpdateServcie;
	// @Before
	// public void before() {
	// ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	// userService = (IUserService) ac.getBean("userService");
	// }

	@Test
	public void test1() {
		int user = userService.deleteByPrimaryKey("1");
		// Gson gson = new Gson();
		// String str = gson.toJson(user);
		// System.out.println(str);
		// System.out.println(user.getcUsername());
		// logger.info("值：" + user.getcUsername());
		logger.info(JSON.toJSONString(user));
	}

	@Test
	public void test2() {
		FirstAid resord = new FirstAid();
		FirstAidInfo resords = new FirstAidInfo();
		resord.setcAmbulancenumber("1111");
		try {
			resord.setcFirstaidid("123456789");

			int a = firstAidService.insert(resord);
			// resords.setcFirstaidid("123456");
			// resords.setcFirstaidinfoid("123456");
			resords.setcBr("111111111111111111111111111");
			int b = firstAidInfoService.insert(resords);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		FirstAidInfo resord = new FirstAidInfo();
		// resord.setcFirstaidid("123456");
		// resord.setcFirstaidinfoid("123456");
		int a = firstAidInfoService.insert(resord);
		System.out.println(a);
	}

	@Test
	public void test4() {
		User user = new User();
		user.setRecordNumPer(5);
		user.setCurrPageIndex(1);
		List<User> a = userService.selectByPage(user);
		int aa = userService.selectByPageCount(user);
		Gson gson = new Gson();
		String str = gson.toJson(a);
		System.out.println(str + "---------------------------------------------" + aa);
	}

	@Test
	public void test5() {
		Organization user = new Organization();
		user.setRecordNumPer(5);
		user.setCurrPageIndex(1);
		List<Organization> a = organizationService.selectByPage(user);
		int aa = organizationService.selectByCount(user);
		System.out.println(a + "---------------------------------------------" + aa);
	}

	@Test
	public void test7() {
		AmbulanceDevice a = new AmbulanceDevice();
		a.setRecordNumPer(5);
		a.setCurrPageIndex(1);
		a.setcOrgid("4a24548b-8f66-4c2a-bb83-40052299b9b4");
		List<AmbulanceDevice> aas = ambulanceDeviceService.selectByPage(a);
		int aa = ambulanceDeviceService.selectByCount(a);
		System.out.println(aas.get(0) + "---------------------------------------------" + aa);
	}

	@Test
	public void test8() {
		String aa = firstAidService.selectFirstAidIDBycCardNumber("123");
		System.out.println("---------------------------------------------" + aa);
	}

	@Test
	public void test9() {
		FirstAidTime f = new FirstAidTime();
		f.setcTimeid(UUID.randomUUID().toString());
		f.setcFirstaidid("testssssssssssssss");
		f.setcTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		f.setcTimenote("testsssssssssss");
		f.setcTimetype("");
		f.setcUpdateuserid("guoxinsssssg");
		int aa = firstAidTimeService.saveOrUpdate(f);
		System.out.println("---------------------------------------------" + aa);
	}

	@Test
	public void test10() {
		FirstAidInfoView firstAidInfoView = new FirstAidInfoView();
//		firstAidInfoView.setcFirstaidid("0c898c2b-aa16-464e-8ade-41d5e4fda271");
		firstAidInfoView.setRecordNumPer(5);
		firstAidInfoView.setCurrPageIndex(1);
//		List<FirstAidInfoView> aa = firstAidInfoViewService.selectFirstAidInfoViewByFirstAidID(firstAidInfoView);
//		int aac = firstAidInfoViewService.selectFirstAidInfoViewByCount(firstAidInfoView);
//		System.out.println("selectFirstAidInfoViewByFirstAidID------"+aac+"---------------------------------------" + aa.get(0).toString());
		
		List<FirstAidInfoView> bb = firstAidInfoViewService.selectFirstAidHistoryView(firstAidInfoView);
		int bbc = firstAidInfoViewService.selectFirstAidHistoryViewCount(firstAidInfoView);
		System.out.println("selectFirstAidHistoryView------------------"+bbc+"---------------------------" + bb.get(0).toString());
	}

	@Test
	public void test11() {
		String fa = firstAidService.selectFirstAidIDBycCardNumber("f0092");
		System.out.println("---------------------------------------------" + fa);
	}

	@Test
	public void test12() {
		List<Organization> organizationList = new ArrayList<Organization>();
		for (int i = 0; i < 5; i++) {
			Organization organization = new Organization();
			organization.setOrgId(i + "corgid");
			organization.setOrgCode(i + "corgcode");
			// organizationService.insert(organization);
			organizationList.add(organization);
		}
		// int a = organizationService.insertBatch(organizationList);
		int a = organizationService.deleteBatch(organizationList);
		System.out.println("-----------------------" + a);
	}

	@Test
	public void test13() {
		FileInfo fileinfo = new FileInfo();
		fileinfo.setcFileid("22ssssssss3");
		fileinfo.setcFilename("22a");
		fileinfo.setcFilepath("22b");
		fileinfo.setcFilesize("22c");
		fileinfo.setcFiletype("22d");
		fileinfo.setcFileforeign("22e");
		fileinfo.setcFileImg("22f");
		fileinfo.setcImageType("1");
		fileinfo.setcType("1");
		fileinfo.setcUpdateTime(new Date());
		int fa = fileService.insert(fileinfo);
		System.out.println("---------------------------------------------" + fa);
	}

	@Test
	public void test14() {

		String fa = firstAidService.selectFirstAidIDBycCardNumber("F0092B");
		String fB = firstAidService.selectFirstAidIDBycCardNumber("f0092b");
		System.out.println("---------------------------------------------" + fa);
		System.out.println("---------------------------------------------" + fB);
	}

	@Test
	public void test15() {
//		List<FirstAidTime> list = new ArrayList<FirstAidTime>();
//		for (int i = 0; i < 5; i++) {
//			FirstAidTime firstAidTime = new FirstAidTime();
//			firstAidTime.setcTimeid("cTimeid" + i);
//			firstAidTime.setcFirstaidid("cFirstaidid" + i);
//			firstAidTime.setcTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//			firstAidTime.setcUpdateuserid("cUpdateuserid" + i);
//			list.add(firstAidTime);
//		}
//		firstAidTimeService.insertBatchAndDelete(list);
		FirstAidTime a  = firstAidTimeService.selectByPrimaryKey("c2ef9935-cfa6-4ce2-9a0b-2b2e21b11f0f");
		System.out.println(a.getcTime());
//		System.out.println(firstAidTimeService.selectByPrimaryByFirstAidTime(list.get(0)).get(0).toString());
	}

	@Test
	public void test16() {
		FirstaidCollection firstaidCollec = new FirstaidCollection();
		firstaidCollec.setcCollectionid("111");
		firstaidCollec.setcFirstaidid("222");
		firstaidCollec.setcFirstaidinfoid("3333");
		firstaidCollec.setcUpdatetime(new Date());
		firstaidCollec.setcUpdateuserid("444");
		firstaidCollectionDao.insert(firstaidCollec);
	}

	@Test
	public void test18() {
		firstAidInfoDao.insertByFirstAidID("bd2b6791-46e6-4590-83c6-1ee60e230717");
	}

	@Test
	public void test19() {
		FollowUpVisits followUpVisits = new FollowUpVisits();
		followUpVisits.setcVisitsid(111);
		followUpVisits.setcPatientsid("111");
		followUpVisits.setcState("0");
		followUpVisits.setcPatientsage(1);
		followUpVisits.setcPatientsname("111");
		followUpVisits.setCurrPageIndex(1);
		followUpVisits.setRecordNumPer(10);
//		 followUpVisitsService.saveOrUpdate(followUpVisits);
//		 followUpVisitsService.deleteByPrimaryKey(111);
		List<FollowUpVisits> a = followUpVisitsService.selectByPage(followUpVisits);
		System.out.println(a.get(0).toString());
		System.out.println(followUpVisitsService.selectByPageCount(followUpVisits));
	}

	@Test
	public void test17() {
		List<ThrombolysisSurvey> list = new ArrayList<ThrombolysisSurvey>();
		for (int i = 0; i < 17; i++) {
			ThrombolysisSurvey t = new ThrombolysisSurvey();
			t.setcSurveyid(UUID.randomUUID().toString());
			t.setcFirstaidid("cFirstaidid");
			t.setcSurveyinfo(String.valueOf(i));
			list.add(t);
		}
//		thrombolysisSurveyService.insertBatch(list);
		 List<ThrombolysisSurvey> a=
		 thrombolysisSurveyService.selectByPrimaryFirstAidID("68cecba9-cbeb-48f2-8418-b74a91385fb5");
		 System.out.println(a.get(0).toString());
		 System.out.println(a.size());
	}
	@Test
	public void test20() {
		FirstaidTask record  = new FirstaidTask();
		record.setcTaskid("11111");
		record.setcPatientsname("cPatientsname");
		record.setcPatientsphone("120");
		record.setcPatientsage("25");
		record.setcPatientssex("男");
		record.setCurrPageIndex(1);
		record.setRecordNumPer(10);
//		firstaidTaskService.saveOrUpdate(record);
//		firstaidTaskService.deleteByPrimaryKey("11111");
		 List<FirstaidTask> a=
				 firstaidTaskService.selectByPage(record);
		 System.out.println(firstaidTaskService.selectByPageCount(record));
		 System.out.println(a.size());
	}
	@Test
	public void test21() {
		FirstaidResults record  = new FirstaidResults();
		record.setCurrPageIndex(1);
		record.setRecordNumPer(10);
		List<FirstaidResults> a=
				firstaidResultsService.selectByPage(record);
		System.out.println(firstaidResultsService.selectByPageCount(record));
		System.out.println(a.size());
	}
	@Test
	public void test22() {
		DeviceUpdate aa = deviceUpdateServcie.selectDeviceUpdateByFirst("97d55245-b800-4d2f-bf3b-9ad1169cf877");
		DeviceUpdate bb = deviceUpdateServcie.selectDeviceUpdateByLast("97d55245-b800-4d2f-bf3b-9ad1169cf877");
		System.out.println(aa.toString());
		System.out.println(bb.toString());
	}

	public static void main(String[] args) {
		FirstAidTime f = new FirstAidTime();
		System.out.println(f.toString());
	}
}
