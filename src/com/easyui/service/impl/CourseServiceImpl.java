package com.easyui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyui.model.SUser;
import com.easyui.model.TCourse;
import com.easyui.service.BaseService;
import com.easyui.service.ICourseService;
import com.easyui.util.BeanUtil;
import com.easyui.util.DateUtil;
import com.easyui.util.StringUtil;


@Service("courseService")
@Transactional
public class CourseServiceImpl extends BaseService implements ICourseService  {

	
	public Map<String, Object> getCourseList(Map<String, String> paraMap, SUser user) {
		
		 //定义map
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		 String coCode = paraMap.containsKey("coCode") ? paraMap.get("coCode") : "";
		 String coName = paraMap.containsKey("coName") ? paraMap.get("coName") : "";
		 String hql = " from TCourse where recStat = '1' " ;
		 if(StringUtil.isNoNull(coCode)){
			 hql += " and coCode = '" + coCode + "'";
		 }
		 if(StringUtil.isNoNull(coName)){
			 hql += " and coName like '" + coName + "%'";
		 }
		List<TCourse> courseList = hqlOperate.getPagedByHql(hql, TCourse.class ,
				(Integer.parseInt(paraMap.get("page")) -1)*Integer.parseInt(paraMap.get("rows")) , 
				Integer.parseInt(paraMap.get("rows")));
		jsonMap.put("total", hqlOperate.getByHql(hql).size());
		jsonMap.put("rows", courseList);
		
		return jsonMap;
	}

	public void editCourse(TCourse tCourse, SUser user) {

		tCourse.setModifyUser(user.getUserid());
		tCourse.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		TCourse t_course = hqlOperate.getById(TCourse.class, tCourse.getKId());
		BeanUtil.copyFields(tCourse, TCourse.class, t_course, TCourse.class);
		hqlOperate.merge(t_course);
	}

	public void addCourse(TCourse tCourse, SUser user) {

		tCourse.setCreateUser(user.getUserid());
		tCourse.setCreateTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		tCourse.setModifyUser(user.getUserid());
		tCourse.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		hqlOperate.save(tCourse);
	}

	public boolean batchDel(String keyIds) {
		if(StringUtil.isNotNull(keyIds)){
			try{
				jdbcTemplate.execute(" update T_COURSE set rec_stat='0' where k_id in( " + keyIds + " )" );
				return true;
			}catch(Exception e){
				return false;
			}
			
		}else{
			return false;
		}
		
	}

}