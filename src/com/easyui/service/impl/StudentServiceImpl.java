package com.easyui.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyui.model.SUser;
import com.easyui.model.TStudent;
import com.easyui.service.BaseService;
import com.easyui.service.IStudentService;
import com.easyui.util.BeanUtil;
import com.easyui.util.DateUtil;
import com.easyui.util.StringUtil;

@Service("studentService")
@Transactional
public class StudentServiceImpl extends BaseService implements IStudentService  {

	

	public Map<String, Object> getStudentList(Map<String, String> paraMap, SUser user) {
		
		 //定义map
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 
		 String stCode = paraMap.containsKey("stCode") ? paraMap.get("stCode") : "";
		 String stName = paraMap.containsKey("stName") ? paraMap.get("stName") : "";
		 String hql = " from TStudent where recStat = '1' " ;
		 if(StringUtil.isNoNull(stCode)){
			 hql += " and stCode = '" + stCode + "'";
		 }
		 if(StringUtil.isNoNull(stName)){
			 hql += " and stName like '" + stName + "%'";
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
				jdbcTemplate.execute(" update T_STUDENT set rec_stat='0' where k_id in( " + keyIds + " )" );
				return true;
			}catch(Exception e){
				return false;
			}
			
		}else{
			return false;
		}
		
	}

	public void editStudent(TStudent student, SUser user) {

		student.setModifyUser(user.getUserid());
		student.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		TStudent t_student = hqlOperate.getById(TStudent.class, student.getKId());
		BeanUtil.copyFields(student, TStudent.class, t_student, TStudent.class);
		hqlOperate.merge(t_student);
	}

	public void addStudent(TStudent student, SUser user) {
		
		student.setCreateUser(user.getUserid());
		student.setCreateTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		student.setModifyUser(user.getUserid());
		student.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		hqlOperate.save(student);
		
	}

	public List<Map<String, String>> getClassComboData(
			Map<String, String> paraMap, SUser user) {
		
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("value", "");
		map.put("text", "--请选择--");
		mapList.add(map);
		
		String sql = "select CL_CODE,CL_NAME from T_CLASS where REC_STAT = '1' order by CL_CODE";
		List<Map<String, String>> list = jdbcTemplate.query(sql,
				new RowMapper<Map<String, String>>() {
					public Map<String, String> mapRow(ResultSet rs, int index)
							throws SQLException {
						Map<String, String> map = new HashMap<String, String>();
						map.put("value", rs.getString(1));
						map.put("text", rs.getString(2));
						return map;
					}
				});

		mapList.addAll(list);
		return mapList;
	}

}
