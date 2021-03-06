package com.cn.hwyl.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hwyl.pojo.AmbulanceDevice;
import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.FirstAidInfo;
import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.Organization;
import com.cn.hwyl.pojo.User;
import com.cn.hwyl.pojo.body.firstAid.FirstAidAddBody;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
//import com.google.gson.Gson;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
//@Transactional //是否回滚
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Autowired
	private IUserService userService ;
	@Resource
	private IFirstAidService firstAidService;
	@Resource
	private IFirstAidInfoService firstAidInfoService;
	@Resource
	private IOrganizationService organizationService;
	@Resource
	IAmbulanceDeviceService ambulanceDeviceService;
	@Resource
	IFrontConfigurationService frontConfigurationService;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
		User user = userService.selectByPrimaryKey("1");
		Gson gson = new Gson();
		String str = gson.toJson(user);
		System.out.println(str);
		System.out.println(user.getcUsername());
		logger.info("值：" + user.getcUsername());
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
//			resords.setcFirstaidid("123456");
//			resords.setcFirstaidinfoid("123456");
			resords.setcBr("111111111111111111111111111");
			int b = firstAidInfoService.insert(resords);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test3() {
		FirstAidInfo resord = new FirstAidInfo();
		resord.setcFirstaidid("123456");
		resord.setcFirstaidinfoid("123456");
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
		System.out.println(str+"---------------------------------------------"+aa);
	}
	@Test
	public void test5() {
		Organization user = new Organization();
		user.setRecordNumPer(5);
		user.setCurrPageIndex(1);
		List<Organization> a = organizationService.selectByPage(user);
		int aa = organizationService.selectByCount(user);
		System.out.println(a+"---------------------------------------------"+aa);
	}
	@Test
	public void test7() {
		AmbulanceDevice a = new AmbulanceDevice();
		a.setRecordNumPer(5);
		a.setCurrPageIndex(1);
		a.setcOrgid("4a24548b-8f66-4c2a-bb83-40052299b9b4");
		List<AmbulanceDevice> aas = ambulanceDeviceService.selectByPage(a);
		int aa = ambulanceDeviceService.selectByCount(a);
		System.out.println(aas.get(0)+"---------------------------------------------"+aa);
	}
	
	@Test
	public void test8() {
		FrontConfiguration f = new FrontConfiguration();
		f.setcOrgid("123");
		frontConfigurationService.insert(f);
		System.out.println(frontConfigurationService.selectByPrimaryKey("123").getcOrgid());
	}
	
	public static void main(String[] args) {

		HeadRequest h = new HeadRequest();
		h.setService("FirstAid_Add");
		BodyRequest b = new BodyRequest();
		FirstAidAddBody faa = new FirstAidAddBody();
		FirstAid fa = new FirstAid();
		fa.setcFirstaidid("123456");
		fa.setcAmbulancenumber("郭星星");

		FirstAidInfo fai = new FirstAidInfo();
		// fai.setcFirstaidinfoid("123456");

		faa.setFirstAid(fa);
		faa.setFirstAidInfo(fai);
		b.setFirstAidAddBody(faa);
	
	}
}
