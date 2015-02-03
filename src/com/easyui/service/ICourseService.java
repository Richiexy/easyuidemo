package com.easyui.service;

import java.util.List;
import java.util.Map;

import com.easyui.model.SUser;
import com.easyui.model.TCourse;

public interface ICourseService {

	/**
	 * @Description: 课程列表
	 * @author: 俞根海
	 * @date: 2015-2-3 下午3:01:25
	 * @param paraMap
	 * @param user
	 * @return
	 */
	Map<String, Object> getCourseList(Map<String, String> paraMap, SUser user);

	/**
	 * @Description: 修改
	 * @author: 俞根海
	 * @date: 2015-2-3 下午3:01:22
	 * @param tCourse
	 * @param user
	 */
	void editCourse(TCourse tCourse, SUser user);

	/**
	 * @Description: 新增
	 * @author: 俞根海
	 * @date: 2015-2-3 下午3:01:18
	 * @param tCourse
	 * @param user
	 */
	void addCourse(TCourse tCourse, SUser user);

	/**
	 * @Description: 批量删除
	 * @author: 俞根海
	 * @date: 2015-2-3 下午3:01:15
	 * @param keyIds
	 * @return
	 */
	boolean batchDel(String keyIds);

}
