package com.easyui.service;

import java.util.List;
import java.util.Map;

import com.easyui.model.SUser;
import com.easyui.model.TTeacher;

public interface ITeacherService {

	/**
	 * @Description: 得到教师列表
	 * @author: 俞根海
	 * @date: 2015-2-2 下午6:27:19
	 * @param paraMap
	 * @param user
	 * @return
	 */
	List<TTeacher> getTeacherList(Map<String, String> paraMap, SUser user);

	/**
	 * @Description: 修改
	 * @author: 俞根海
	 * @date: 2015-2-2 下午6:27:28
	 * @param teacher
	 * @param user
	 */
	void editTeacher(TTeacher teacher, SUser user);

	/**
	 * @Description: 新增
	 * @author: 俞根海
	 * @date: 2015-2-2 下午6:27:38
	 * @param teacher
	 * @param user
	 */
	void addTeacher(TTeacher teacher, SUser user);

	/**
	 * @Description: 批量删除
	 * @author: 俞根海
	 * @date: 2015-2-2 下午6:27:46
	 * @param keyIds
	 * @return
	 */
	boolean batchDel(String keyIds);

}
