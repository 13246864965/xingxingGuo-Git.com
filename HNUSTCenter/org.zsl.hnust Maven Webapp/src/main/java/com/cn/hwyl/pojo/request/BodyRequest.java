package com.cn.hwyl.pojo.request;

import java.io.Serializable;

import com.cn.hwyl.pojo.body.ambulanceDevice.AmbulanceDeviceSelectBody;
import com.cn.hwyl.pojo.body.ambulanceDevice.DeviceUpdatSelectBody;
import com.cn.hwyl.pojo.body.ambulanceDevice.DeviceUpdateBody;
import com.cn.hwyl.pojo.body.fileInfo.FileInfoSelectBody;
import com.cn.hwyl.pojo.body.firstAid.FirstAidAddBody;
import com.cn.hwyl.pojo.body.firstAid.FirstAidEditBody;
import com.cn.hwyl.pojo.body.firstAid.FirstAidSelectBody;
import com.cn.hwyl.pojo.body.firstAid.FirstAidUpdateBody;
import com.cn.hwyl.pojo.body.organize.ConfigurationEditBody;
import com.cn.hwyl.pojo.body.organize.OrganizeAddBody;
import com.cn.hwyl.pojo.body.organize.OrganizeSelectBody;
import com.cn.hwyl.pojo.body.organize.OrganizeUpdateBody;
import com.cn.hwyl.pojo.body.permissions.PermissionsAddBody;
import com.cn.hwyl.pojo.body.permissions.PermissionsDeleteBody;
import com.cn.hwyl.pojo.body.permissions.PermissionsSelectBody;
import com.cn.hwyl.pojo.body.permissions.PermissionsUpdateBody;
import com.cn.hwyl.pojo.body.role.RoleAddBody;
import com.cn.hwyl.pojo.body.role.RoleSelectBody;
import com.cn.hwyl.pojo.body.role.RoleUpdateBody;
import com.cn.hwyl.pojo.body.user.UserAddBody;
import com.cn.hwyl.pojo.body.user.UserDeleteBody;
import com.cn.hwyl.pojo.body.user.UserEditBody;
import com.cn.hwyl.pojo.body.user.UserLoginBody;
import com.cn.hwyl.pojo.body.user.UserSelectBody;
import com.cn.hwyl.pojo.body.user.UserUpdateBody;

public class BodyRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8619980915810695488L;

	//分页信息
	private PageInputContext pageInputContext;
	
	//用户登录
	private UserLoginBody userLoginBody;
	//用户添加
	private UserAddBody userAddBody;
	//用户更新
	private UserUpdateBody userUpdate;
	//用户删除
	private UserDeleteBody userDeleteBody;
	//用户查询
	private UserSelectBody userSelectBody;
	
	private UserEditBody userEditBody;
	
	//急救信息添加
	private FirstAidAddBody firstAidAddBody;
	//急救信息修改
	private FirstAidUpdateBody firstAidUpdateBody;
	//急救列表查询
	private FirstAidSelectBody firstAidSelectBody;
	//急救信息编辑
	private FirstAidEditBody firstAidEditBody;
	
	
	
	//权限添加
	private PermissionsAddBody permissionsAddBody;
	//权限更改
	private PermissionsUpdateBody permissionsUpdateBody;
	//权限删除
	private PermissionsDeleteBody permissionsDeleteBody;
	//权限查询
	private PermissionsSelectBody permissionsSelectBody;
	
	
	
	
	//机构添加
	private OrganizeAddBody OrganizeAddBody;
	//机构信息更新
	private OrganizeUpdateBody OrganizeUpdateBody;
	//机构查询
	private OrganizeSelectBody organizeSelectBody;
	
	
	//角色添加
	private RoleAddBody roleAddBody;
	//角色更新
	private RoleUpdateBody roleUpdateBody;
	//角色查询
	private RoleSelectBody roleSelectBody;
		

	//设备查询
	private AmbulanceDeviceSelectBody ambulanceDeviceSelectBody; 
	//更换设备
	private DeviceUpdateBody deviceUpdateBody;
	//查询
	private DeviceUpdatSelectBody deviceUpdatSelectBody;
	
	
	
	//文件查询
	private FileInfoSelectBody fileInfoSelectBody;
	
	//组织ID
	private String cOrgId;
	
	
	//中心端服务配置
	private ConfigurationEditBody configurationEditBody;
	
	
	

	public ConfigurationEditBody getConfigurationEditBody() {
		return configurationEditBody;
	}

	public void setConfigurationEditBody(ConfigurationEditBody configurationEditBody) {
		this.configurationEditBody = configurationEditBody;
	}

	public FirstAidEditBody getFirstAidEditBody() {
		return firstAidEditBody;
	}

	public void setFirstAidEditBody(FirstAidEditBody firstAidEditBody) {
		this.firstAidEditBody = firstAidEditBody;
	}

	public UserEditBody getUserEditBody() {
		return userEditBody;
	}

	public void setUserEditBody(UserEditBody userEditBody) {
		this.userEditBody = userEditBody;
	}

	public String getcOrgId() {
		return cOrgId;
	}

	public void setcOrgId(String cOrgId) {
		this.cOrgId = cOrgId;
	}

	public FileInfoSelectBody getFileInfoSelectBody() {
		return fileInfoSelectBody;
	}

	public void setFileInfoSelectBody(FileInfoSelectBody fileInfoSelectBody) {
		this.fileInfoSelectBody = fileInfoSelectBody;
	}

	public DeviceUpdatSelectBody getDeviceUpdatSelectBody() {
		return deviceUpdatSelectBody;
	}

	public void setDeviceUpdatSelectBody(DeviceUpdatSelectBody deviceUpdatSelectBody) {
		this.deviceUpdatSelectBody = deviceUpdatSelectBody;
	}

	public DeviceUpdateBody getDeviceUpdateBody() {
		return deviceUpdateBody;
	}

	public void setDeviceUpdateBody(DeviceUpdateBody deviceUpdateBody) {
		this.deviceUpdateBody = deviceUpdateBody;
	}

	public RoleSelectBody getRoleSelectBody() {
		return roleSelectBody;
	}

	public void setRoleSelectBody(RoleSelectBody roleSelectBody) {
		this.roleSelectBody = roleSelectBody;
	}

	public PermissionsSelectBody getPermissionsSelectBody() {
		return permissionsSelectBody;
	}

	public void setPermissionsSelectBody(PermissionsSelectBody permissionsSelectBody) {
		this.permissionsSelectBody = permissionsSelectBody;
	}

	public RoleUpdateBody getRoleUpdateBody() {
		return roleUpdateBody;
	}

	public void setRoleUpdateBody(RoleUpdateBody roleUpdateBody) {
		this.roleUpdateBody = roleUpdateBody;
	}

	public AmbulanceDeviceSelectBody getAmbulanceDeviceSelectBody() {
		return ambulanceDeviceSelectBody;
	}

	public void setAmbulanceDeviceSelectBody(AmbulanceDeviceSelectBody ambulanceDeviceSelectBody) {
		this.ambulanceDeviceSelectBody = ambulanceDeviceSelectBody;
	}

	public PermissionsDeleteBody getPermissionsDeleteBody() {
		return permissionsDeleteBody;
	}

	public void setPermissionsDeleteBody(PermissionsDeleteBody permissionsDeleteBody) {
		this.permissionsDeleteBody = permissionsDeleteBody;
	}

	public PermissionsUpdateBody getPermissionsUpdateBody() {
		return permissionsUpdateBody;
	}

	public void setPermissionsUpdateBody(PermissionsUpdateBody permissionsUpdateBody) {
		this.permissionsUpdateBody = permissionsUpdateBody;
	}

	public PermissionsAddBody getPermissionsAddBody() {
		return permissionsAddBody;
	}

	public void setPermissionsAddBody(PermissionsAddBody permissionsAddBody) {
		this.permissionsAddBody = permissionsAddBody;
	}

	public FirstAidSelectBody getFirstAidSelectBody() {
		return firstAidSelectBody;
	}

	public void setFirstAidSelectBody(FirstAidSelectBody firstAidSelectBody) {
		this.firstAidSelectBody = firstAidSelectBody;
	}

	public FirstAidUpdateBody getFirstAidUpdateBody() {
		return firstAidUpdateBody;
	}

	public void setFirstAidUpdateBody(FirstAidUpdateBody firstAidUpdateBody) {
		this.firstAidUpdateBody = firstAidUpdateBody;
	}

	public UserSelectBody getUserSelectBody() {
		return userSelectBody;
	}

	public void setUserSelectBody(UserSelectBody userSelectBody) {
		this.userSelectBody = userSelectBody;
	}

	public OrganizeSelectBody getOrganizeSelectBody() {
		return organizeSelectBody;
	}

	public void setOrganizeSelectBody(OrganizeSelectBody organizeSelectBody) {
		this.organizeSelectBody = organizeSelectBody;
	}

	public OrganizeUpdateBody getOrganizeUpdateBody() {
		return OrganizeUpdateBody;
	}

	public void setOrganizeUpdateBody(OrganizeUpdateBody organizeUpdateBody) {
		OrganizeUpdateBody = organizeUpdateBody;
	}

	public RoleAddBody getRoleAddBody() {
		return roleAddBody;
	}

	public void setRoleAddBody(RoleAddBody roleAddBody) {
		this.roleAddBody = roleAddBody;
	}

	public OrganizeAddBody getOrganizeAddBody() {
		return OrganizeAddBody;
	}

	public void setOrganizeAddBody(OrganizeAddBody organizeAddBody) {
		OrganizeAddBody = organizeAddBody;
	}

	public UserDeleteBody getUserDeleteBody() {
		return userDeleteBody;
	}

	public void setUserDeleteBody(UserDeleteBody userDeleteBody) {
		this.userDeleteBody = userDeleteBody;
	}

	public UserUpdateBody getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(UserUpdateBody userUpdate) {
		this.userUpdate = userUpdate;
	}

	public PageInputContext getPageInputContext() {
		return pageInputContext;
	}

	public void setPageInputContext(PageInputContext pageInputContext) {
		this.pageInputContext = pageInputContext;
	}

	public UserLoginBody getUserLoginBody() {
		return userLoginBody;
	}

	public void setUserLoginBody(UserLoginBody userLoginBody) {
		this.userLoginBody = userLoginBody;
	}

	public UserAddBody getUserAddBody() {
		return userAddBody;
	}

	public void setUserAddBody(UserAddBody userAddBody) {
		this.userAddBody = userAddBody;
	}

	public FirstAidAddBody getFirstAidAddBody() {
		return firstAidAddBody;
	}

	public void setFirstAidAddBody(FirstAidAddBody firstAidAddBody) {
		this.firstAidAddBody = firstAidAddBody;
	}

	
	
}
