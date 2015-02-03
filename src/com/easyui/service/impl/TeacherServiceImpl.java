package com.easyui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyui.model.SUser;
import com.easyui.model.TTeacher;
import com.easyui.service.BaseService;
import com.easyui.service.ITeacherService;
import com.easyui.util.BeanUtil;
import com.easyui.util.DateUtil;
import com.easyui.util.StringUtil;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl extends BaseService implements ITeacherService  {

	

	public Map<String, Object> getTeacherList(Map<String, String> paraMap, SUser user) {
		
		 //定义map
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 
		 String tcCode = paraMap.containsKey("tcCode") ? paraMap.get("tcCode") : "";
		 String tcName = paraMap.containsKey("tcName") ? paraMap.get("tcName") : "";
		 String hql = " from TTeacher where recStat = '1' " ;
		 if(StringUtil.isNoNull(tcCode)){
			 hql += " and tcCode = '" + tcCode + "'";
		 }
		 if(StringUtil.isNoNull(tcName)){
			 hql += " and tcName like '" + tcName + "%'";
		 }
		List<SUser> userList = hqlOperate.getPagedByHql(hql, SUser.class ,
				(Integer.parseInt(paraMap.get("page")) -1)*Integer.parseInt(paraMap.get("rows")) , 
				Integer.parseInt(paraMap.get("rows")));
		jsonMap.put("total", hqlOperate.getByHql(hql).size());
		jsonMap.put("rows", userList);
		return jsonMap;
	}

	public boolean batchDel(String keyIds) {
		if(StringUtil.isNotNull(keyIds)){
			try{
				jdbcTemplate.execute(" update T_TEACHER set rec_stat='0' where k_id in( " + keyIds + " )" );
				return true;
			}catch(Exception e){
				return false;
			}
			
		}else{
			return false;
		}
		
	}

	public void editTeacher(TTeacher teacher, SUser user) {

		teacher.setModifyUser(user.getUserid());
		teacher.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		TTeacher t_teacher = hqlOperate.getById(TTeacher.class, teacher.getKId());
		BeanUtil.copyFields(teacher, TTeacher.class, t_teacher, TTeacher.class);
		hqlOperate.merge(t_teacher);
	}

	public void addTeacher(TTeacher teacher, SUser user) {
		
		teacher.setCreateUser(user.getUserid());
		teacher.setCreateTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		teacher.setModifyUser(user.getUserid());
		teacher.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		hqlOperate.save(teacher);
		
	}

}
