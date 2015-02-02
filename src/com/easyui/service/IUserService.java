package com.easyui.service;

import java.util.List;
import java.util.Map;

import com.easyui.model.SUser;

/**
 * @Description: 用户接口
 * @author: 俞根海
 * @date： 2015-1-29 上午11:21:53
 */
public interface IUserService {

	/**
	 * @Description: 按用户ID查询用户
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:22:02
	 * @param userid
	 * @return
	 */
	public SUser getByUserId(String userid);

	/**
	 * @Description: 得到用户列表
	 * @author: 俞根海
	 * @date: 2015-2-2 下午3:24:04
	 * @param paraMap
	 * @param user
	 * @return
	 */
	public List<SUser> getUserList(Map<String, String> paraMap, SUser user);

	/**
	 * @Description: 批量删除
	 * @author: 俞根海
	 * @date: 2015-2-2 下午3:25:26
	 * @param keyIds
	 * @return
	 */
	public boolean batchDel(String keyIds);

	/**
	 * @Description: 修改用户信息
	 * @author: 俞根海
	 * @date: 2015-2-2 下午3:26:45
	 * @param tmpUser
	 * @param user
	 */
	public void editUser(SUser tmpUser, SUser user);

	/**
	 * @Description: 新增用户信息
	 * @author: 俞根海
	 * @date: 2015-2-2 下午3:27:01
	 * @param tmpUser
	 * @param user
	 */
	public void addUser(SUser tmpUser, SUser user);
}
