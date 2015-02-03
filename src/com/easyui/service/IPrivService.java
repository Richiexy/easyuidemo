package com.easyui.service;

import java.util.List;
import java.util.Map;

import com.easyui.model.SPriv;
import com.easyui.model.SUser;

/**
 * @Description: 权限接口
 * @author: 俞根海
 * @date： 2015-1-29 上午11:22:16
 */
public interface IPrivService {

	/**
	 * @Description: 获取权限数据列表
	 * @author: 俞根海
	 * @date: 2015-2-2 下午4:39:09
	 * @param paraMap
	 * @param user
	 * @return
	 */
	Map<String, Object> getPrivList(Map<String, String> paraMap, SUser user);

	/**
	 * @Description: 修改
	 * @author: 俞根海
	 * @date: 2015-2-2 下午4:39:23
	 * @param sPriv
	 * @param user
	 */
	void editPriv(SPriv sPriv, SUser user);

	/**
	 * @Description: 新增
	 * @author: 俞根海
	 * @date: 2015-2-2 下午4:39:33
	 * @param sPriv
	 * @param user
	 */
	void addPriv(SPriv sPriv, SUser user);

	/**
	 * @Description: 批量删除
	 * @author: 俞根海
	 * @date: 2015-2-2 下午4:39:43
	 * @param keyIds
	 * @return
	 */
	boolean batchDel(String keyIds);

}
