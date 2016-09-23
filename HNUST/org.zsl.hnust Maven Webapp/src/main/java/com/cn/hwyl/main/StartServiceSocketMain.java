package com.cn.hwyl.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.cn.hwyl.socket.ChatServerByDoctors;

/**
 * Trigger to consume data from Nucleon Event Bus
 */
//@Component("processor")
public class StartServiceSocketMain extends HttpServlet {

	private static final long serialVersionUID = -9045451275234606838L;

	private static final Logger logger = Logger.getLogger(StartServiceSocketMain.class);

	// Servlet的init方法会在Tomcat启动的时候执行
	@Override
	public void init() throws ServletException {
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// 使用另一个线程来执行该方法，会避免占用Tomcat的启动时间
				start();
				return "Collection Completed";
			}
		});
		new Thread(task).start();
	}

	// 希望Tomcat启动结束后执行的方法
	private void start() {
		try {
			ChatServerByDoctors chatServer = new ChatServerByDoctors();
			chatServer.startWork();
		} catch (Exception e) {
			logger.error(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())
					+ ":StartServiceSocket contextInitialized faild!!");
		}
	}

}
