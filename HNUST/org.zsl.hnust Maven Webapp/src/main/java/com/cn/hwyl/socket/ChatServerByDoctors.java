package com.cn.hwyl.socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.main.StartMsdlServiceMain;
import com.cn.hwyl.pojo.ConsultationInfo;
import com.cn.hwyl.service.IConsultationInfoService;

/**
 * 	
 */
class Chat extends Thread {
	private static Logger logger = Logger.getLogger(Chat.class);
	private Socket socket;
	private List<Socket> socketList;
	private int count;

	public Chat(int count, Socket socket, List<Socket> socketList) {
		this.count = count;
		this.socket = socket;
		this.socketList = socketList;
	}

	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String message = null;
			while (true) {
				message = reader.readLine();
				// 接收到客户端的bye信息，客户端即将退出，并将bye写入到该客户端
				if (message.equals("bye")) {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println("bye");
					writer.flush();
					continue;
				}

				// 向所有的客户端发送接收到信息，实现群聊
				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i)
							.getOutputStream());
					//输出聊天信息
					writer.println(message);
					writer.flush();
				}
				logger.info("message---------"+message);
				//当聊天信息发送出去后保存数据入库
				saveConsultationInfo(message);

			}
		} catch (IOException e) {
			socketList.remove(socket);
			try {
				socket.close();
			} catch (IOException e1) {
				throw new RuntimeException();
			}
			count--;
			throw new RuntimeException();
		}
	}

	//保存会诊记录到数据库
	private void saveConsultationInfo(String consultationInfo) {
//		if (consultationInfo != null) {
//			@SuppressWarnings("resource")
//			ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//			IConsultationInfoService consultationInfoService = (IConsultationInfoService) ac
//					.getBean("consultationInfoService");
//			ConsultationInfo c = new ConsultationInfo();
//			c.setcOrgid(consultationInfo.split(",")[1]);
//			c.setcFirstaidid(consultationInfo.split(",")[2]);
//			c.setcConsultationuserid(consultationInfo.split(",")[3]);
//			c.setcConsultationtime(new Date());
//			c.setcConsultationcontent(consultationInfo.split(",")[4]);
//			c.setcConsultationid(UUID.randomUUID().toString());
//			try {
//				consultationInfoService.insert(c);
//			} catch (Exception e) {
//				throw new RuntimeException();
//			}
//
//		}
	}

}

public class ChatServerByDoctors {

	
	private static Logger logger = Logger.getLogger(ChatServerByDoctors.class);
	

	/**
	 * Description
	 * 
	 * @param args
	 */
	@SuppressWarnings("resource")
	public void startWork(){
		// 创建一个ServerSocket在端口2121监听客户请求
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(2121);
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
			System.out.println(count + " clinet connected to the server!");
			// 将每一个连接到该服务器的客户端，加到List中
			socketList.add(socket);
			// 每一个连接到服务器的客户端，服务器开启一个新的线程来处理
			new Chat(count, socket, socketList).start();
		}
	}
	
	/**
	 * Description
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ChatServerByDoctors chatServer = new ChatServerByDoctors();
		chatServer.startWork();
	}

}