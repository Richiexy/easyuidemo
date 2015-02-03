package com.easyui.service;

import java.util.List;
import java.util.Map;

import com.easyui.model.SUser;
import com.easyui.model.TStudent;

public interface IStudentService {

	/**
	 * @Description: 得到学生列表
	 * @author: 俞根海
	 * @date: 2015-2-3 下午9:25:32
	 * @param paraMap
	 * @param user
	 * @return
	 */
	Map<String, Object> getStudentList(Map<String, String> paraMap, SUser user);

	/**
	 * @Description: 修改
	 * @author: 俞根海
	 * @date: 2015-2-3 下午9:25:44
	 * @param teacher
	 * @param user
	 */
	void editStudent(TStudent teacher, SUser user);

	/**
	 * @Description: 新增
	 * @author: 俞根海
	 * @date: 2015-2-3 下午9:25:51
	 * @param teacher
	 * @param user
	 */
	void addStudent(TStudent teacher, SUser user);

	/**
	 * @Description: 批量删除
	 * @author: 俞根海
	 * @date: 2015-2-3 下午9:25:59
	 * @param keyIds
	 * @return
	 */
	boolean batchDel(String keyIds);

	/**
	 * @Description: 得到班级下拉列表
	 * @author: 俞根海
	 * @date: 2015-2-3 下午10:28:26
	 * @param paraMap
	 * @param user
	 * @return
	 */
	List<Map<String, String>> getClassComboData(Map<String, String> paraMap,
			SUser user);

}
