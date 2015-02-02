package com.easyui.service;

import java.util.List;
import java.util.Map;

import com.easyui.model.SRole;
import com.easyui.model.SUser;

/**
 * @Description: 角色接口
 * @author: 俞根海
 * @date： 2015-1-29 上午11:22:16
 */
public interface IRoleService {

	/**
	 * @Description: 获取角色数据列表
	 * @author: 俞根海
	 * @date: 2015-2-2 下午4:39:09
	 * @param paraMap
	 * @param user
	 * @return
	 */
	List<SRole> getRoleList(Map<String, String> paraMap, SUser user);

	/**
	 * @Description: 修改
	 * @author: 俞根海
	 * @date: 2015-2-2 下午4:39:23
	 * @param sRole
	 * @param user
	 */
	void editRole(SRole sRole, SUser user);

	/**
	 * @Description: 新增
	 * @author: 俞根海
	 * @date: 2015-2-2 下午4:39:33
	 * @param sRole
	 * @param user
	 */
	void addRole(SRole sRole, SUser user);

	/**
	 * @Description: 批量删除
	 * @author: 俞根海
	 * @date: 2015-2-2 下午4:39:43
	 * @param keyIds
	 * @return
	 */
	boolean batchDel(String keyIds);

}
