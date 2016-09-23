package com.cn.hwyl.pojo;

import java.util.List;

/**
 * 心电图返回接口实体
 * @author hw01
 *
 */
public class EgcEntity {
	private String success;
	private String wid;
	private List<M3_egc> result;

	public class M3_egc {
		private String beginTime;
		private String pureData;
		private String titleData;

		public String getBeginTime() {
			return beginTime;
		}

		public void setBeginTime(String beginTime) {
			this.beginTime = beginTime;
		}

		public String getPureData() {
			return pureData;
		}

		public void setPureData(String pureData) {
			this.pureData = pureData;
		}

		public String getTitleData() {
			return titleData;
		}

		public void setTitleData(String titleData) {
			this.titleData = titleData;
		}

		@Override
		public String toString() {
			return "M3_egc [beginTime=" + beginTime + ", pureData=" + pureData + ", titleData=" + titleData + "]";
		}
		
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public List<M3_egc> getResult() {
		return result;
	}

	public void setResult(List<M3_egc> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "EgcEntity [success=" + success + ", wid=" + wid + ", result=" + result+ "]";
	}

}
