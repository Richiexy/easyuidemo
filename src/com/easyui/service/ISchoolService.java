package com.easyui.service;

import java.util.List;
import java.util.Map;

import com.easyui.model.SUser;
import com.easyui.model.TSchool;

/**
 * @Description: 学校接口
 * @author: 俞根海
 * @date： 2015-1-29 上午11:22:16
 */
public interface ISchoolService {

	/**
	 * @Description: 按学校编码查找学校
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:23:22
	 * @param scCode
	 * @return
	 */
	public TSchool getByScCode(String scCode);
	
	/**
	 * @Description: 查找所有学校
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:24:25
	 * @return
	 */
	public List<TSchool> findAllSchool();
	
	/**
	 * @Description: 新增学校
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:25:10
	 * @param school
	 * @param user 
	 */
	public void addSchool(TSchool school, SUser user);
	
	/**
	 * @Description: 修改学校
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:25:59
	 * @param school
	 * @param user 
	 */
	public void editSchool(TSchool school, SUser user);
	
	/**
	 * @Description: 删除，（逻辑删除，置标志位）
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:26:08
	 * @param keyIds
	 * @return
	 */
	public boolean batchDel(String keyIds);

	/**
	 * @Description:查找学校
	 * @author: 俞根海
	 * @date: 2015-2-2 下午2:34:08
	 * @param paraMap
	 * @param user
	 * @return
	 */
	public Map<String, Object> getSchoolList(Map<String, String> paraMap, SUser user);
}
