package com.cn.hwyl.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.FirstAidTime;
import com.cn.hwyl.service.IFirstAidService;
import com.cn.hwyl.service.IFirstAidTimeService;

class ChatByCardNumber extends Thread {
	private static Logger logger = Logger.getLogger(ChatByCardNumber.class);
	private Socket socket;
	private List<Socket> socketList;
	private int count;
	Set<String> set = new HashSet<String>();
	Map<String,Date> map = new HashMap<String,Date>();

	public ChatByCardNumber(int count, Socket socket, List<Socket> socketList) {
		this.count = count;
		this.socket = socket;
		this.socketList = socketList;
	}

	public void run() {
		InputStream in = null;
		try {
			in = socket.getInputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		boolean flag = true;
		try {
			while (flag) {
				if (in.read() == -1) {
					count--;
					socket.close();
					return;
				}

				byte[] outData = new byte[0];
				DataInputStream socketIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				Date startDate = new Date();
				int ioffset = 0;
				int iLen = 0;
				byte[] buffer = new byte[1024];

				if ((iLen = socketIn.read(buffer, 0, 1024)) != -1) {
					// iLen = socketIn.read(buffer, 0, 1024);
					outData = new byte[outData.length + iLen];
					System.arraycopy(buffer, 0, outData, ioffset, iLen);
					ioffset += iLen;
				}
				// String message = new String(outData);
				// logger.info(socket.getInetAddress().getHostAddress() +
				// "message:--------" + message);
				String h = "";
				for (int i = 0; i < outData.length; i++) {
					String temp = Integer.toHexString(outData[i] & 0xFF);
					if (temp.length() == 1) {
						temp = "0" + temp;
					}
					h = h + temp;
				}
				logger.info(socket.getInetAddress().getHostAddress() + "       h:--------" + h);

//				// //门的类型
//				boolean isOk = set.add(h.trim());
//				// 判断此次socket发送过来的信息是否存在
//				if (isOk) {
//					// 插入成功,当前患者刷了n信息后remove 集合，在加入当前 h
//					if (set.size() > 7) {
//						set.clear();
//					}
//					set.add(h.trim());
//					System.out.println(socket.getInetAddress().getHostAddress() +"socketSize*************" + set.size());
//					saveFirstAidTime(h.trim());
//				}
				
				String cCardNumber = h.trim().substring(2, 8);
				Date cCardNumberDate = map.get(cCardNumber);
				//标签号不存在 添加入库
				if (cCardNumberDate == null) {
					map.put(cCardNumber, startDate);
					saveFirstAidTime(h.trim(), startDate);
				} else {
					// 如果存在则 判断当前时间与 存在标签时间的差值，大于10s则更新map，重新入库
					long between = (startDate.getTime() - cCardNumberDate.getTime()) / 1000;// 除以1000是为了转换成秒
					if (between > 10) {
						map.put(cCardNumber, startDate);
						saveFirstAidTime(h.trim(), startDate);
					}
				}
			}
		} catch (IOException e) {
			count--;
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	// 存储RFID时间到数据库
	private void saveFirstAidTime(String message,Date startDate) {
		logger.info("saveFirstAidTime param--------------" + message);
		if (message != null) {
			@SuppressWarnings("resource")
			ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
			IFirstAidTimeService firstAidTimeService = (IFirstAidTimeService) ac.getBean("firstAidTimeService");

			IFirstAidService firstAidService = (IFirstAidService) ac.getBean("firstAidService");
			// ff f0 09 2b 00 00 00 00 00 00 00 00 00 00 dd ff

			/**
			 * 根据标签号去查询最新合同号
			 */
			FirstAidTime firstAidTime = new FirstAidTime();
			String cCardNumber = message.trim().substring(2, 8);
			logger.info("saveFirstAidTime param  cCardNumber--------------" + cCardNumber);
			// firstAidID,cCardNumber
			String firstAidID = null;
			try {
				firstAidID = firstAidService.selectFirstAidIDBycCardNumber(cCardNumber);
				if (firstAidID != null) {
					firstAidTime.setcTimeid(UUID.randomUUID().toString());
					firstAidTime.setcFirstaidid(firstAidID.split(",")[0]);
					firstAidTime.setcTime(startDate);
					firstAidTime.setcTimenote("刷卡记录");
					// 根据message.trim().substring(0, 2)判断                                                         需处理
					String cTimetype = message.trim().substring(0, 2).toString();
					cTimetype= "0".equals(cTimetype.substring(0, 1))?cTimetype.substring(1, 2):cTimetype; 
					firstAidTime.setcTimetype(cTimetype);
					firstAidTime.setcUpdateuserid(firstAidID.split(",")[1]);
					firstAidTimeService.saveOrUpdate(firstAidTime);
					logger.info("saveFirstAidTime --------------" + firstAidID+"saveOrUpdate successful!!!");
				}else{
					logger.error("根据标签号：" + cCardNumber + "未查询到合同！！");
				}
			} catch (Exception e) {
				logger.info("saveFirstAidTime --------------" + firstAidID+"saveOrUpdate error!!!"+e);
			}
		}
	}

}

/**
 * socket 用户存放刷卡时间记录
 * 
 * @author hw01
 *
 */
public class ChatServerByCardNumber {

	private static Logger logger = Logger.getLogger(ChatServerByCardNumber.class);

	/**
	 * Description
	 * 
	 * @param args
	 */
	@SuppressWarnings("resource")
	public void startWork() {
		// 创建一个ServerSocket在端口2121监听客户请求
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(2122);
			// serverSocket = new ServerSocket(port, 10,
			// InetAddress.getLocalHost());
			logger.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+" 成功启动ServiceSocket"+serverSocket.getLocalSocketAddress()+"服务！！！");

		} catch (IOException e) {
			System.out.println("create socketService!!! Error. " + e);
		}
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		int count = 0;
		while (true) {
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			count++;
			logger.info(count + " clinet connected to the server!");
			System.out.println(count + " clinet connected to the server!");
			// 将每一个连接到该服务器的客户端，加到List中
			socketList.add(socket);
			// 每一个连接到服务器的客户端，服务器开启一个新的线程来处理
			new ChatByCardNumber(count, socket, socketList).start();
		}
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ChatServerByCardNumber chatServer = new ChatServerByCardNumber();
		chatServer.startWork();

	}

}