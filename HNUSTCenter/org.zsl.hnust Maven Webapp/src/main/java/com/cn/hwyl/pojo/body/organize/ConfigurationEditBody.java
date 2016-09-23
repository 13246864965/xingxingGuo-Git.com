package com.cn.hwyl.pojo.body.organize;

import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.OrgConfiguration;

public class ConfigurationEditBody {
	private OrgConfiguration orgConfiguration;
	private FrontConfiguration frontConfiguration;

	public FrontConfiguration getFrontConfiguration() {
		return frontConfiguration;
	}

	public void setFrontConfiguration(FrontConfiguration frontConfiguration) {
		this.frontConfiguration = frontConfiguration;
	}

	public OrgConfiguration getOrgConfiguration() {
		return orgConfiguration;
	}

	public void setOrgConfiguration(OrgConfiguration orgConfiguration) {
		this.orgConfiguration = orgConfiguration;
	}
}
