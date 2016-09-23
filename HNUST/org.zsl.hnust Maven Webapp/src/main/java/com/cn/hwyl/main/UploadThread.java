package com.cn.hwyl.main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * 心电数据 线程 已上传文件方式
 * 
 */

public class UploadThread {

	private static Logger logger = Logger.getLogger(UploadThread.class);
	private String wardshipId;
	private String Key;
	private String ptime;

	private String WARDSHIPID = "wardshipId";
	private String KEY = "Key";
	private String PTIME = "ptime";

	public UploadThread(String wardshipId, String Key, String ptime) {
		this.wardshipId = wardshipId;
		this.Key = Key;
		this.ptime = ptime;
	}

	public String run() {
		/** 上传文件 返回id 然后xmpp 传递id */
		Map<String, String> body = new HashMap<String, String>();
		body.put(WARDSHIPID, wardshipId);
		body.put(KEY, Key);
		body.put(PTIME, ptime);
		return postMultiParams("http://218.12.10.28:20048/contract/dataTrans/getOneDataPacks", body);
	}

	/**
	 * 通过http协议提交数据到服务端，实现表单提交功能，包括上传文件
	 * 
	 * @param actionUrl
	 *            上传路径
	 * @param params
	 *            请求参数 key为参数名,value为参数值
	 * @param file
	 *            上传文件
	 */
	public String postMultiParams(String actionUrl, Map<String, String> params) {
		logger.info("UploadThread postMultiParams param::"+actionUrl);
		HttpURLConnection conn = null;
		String result = null;
		String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
		try {
			URL url = new URL(actionUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(500000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
			conn.setRequestProperty("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			OutputStream out = new DataOutputStream(conn.getOutputStream());

			// 上传普通参数
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				sb.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
				sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n");
				sb.append("Content-Type: text/plain; charset=UTF-8\r\n");
				sb.append("Content-Transfer-Encoding: 8bit\r\n");
				sb.append("\r\n");
				sb.append(entry.getValue());
			}
			out.write(sb.toString().getBytes());
			out.flush();

			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			result = br.readLine();
			return result;
			// is.close();

		} catch (Exception e) {
			logger.error("UploadThread --postMultiParams errorinfo:" + e);
			throw new RuntimeException();
		}
	}

}
