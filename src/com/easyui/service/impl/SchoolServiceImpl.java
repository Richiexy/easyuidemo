package com.easyui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyui.model.SUser;
import com.easyui.model.TCourse;
import com.easyui.model.TSchool;
import com.easyui.service.BaseService;
import com.easyui.service.ISchoolService;
import com.easyui.util.BeanUtil;
import com.easyui.util.DateUtil;
import com.easyui.util.JacksonUtil;
import com.easyui.util.StringUtil;

@Service("schoolService")
@Transactional
public class SchoolServiceImpl extends BaseService implements ISchoolService  {

	public TSchool getByScCode(String scCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TSchool> findAllSchool() {
		List<TSchool> schoolList = hqlOperate.findByProperty(TSchool.class,
				"recStat", "1", "KId");
		log.info(JacksonUtil.serializeObjectToJson(schoolList, true));
		return schoolList;
	}

	public void addSchool(TSchool school, SUser user) {
		
		school.setCreateUser(user.getUserid());
		school.setCreateTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		school.setModifyUser(user.getUserid());
		school.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		hqlOperate.save(school);
	}

	public void editSchool(TSchool school, SUser user) {
		school.setModifyUser(user.getUserid());
		school.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		TSchool tmpSchool = hqlOperate.getById(TSchool.class, school.getKId());
		BeanUtil.copyFields(school, TSchool.class, tmpSchool, TSchool.class);
		hqlOperate.merge(tmpSchool);
	}

	public boolean batchDel(String keyIds) {
		
		if(StringUtil.isNotNull(keyIds)){
			try{
				jdbcTemplate.execute(" update T_SCHOOL set rec_stat='0' where k_id in( " + keyIds + " )" );
				return true;
			}catch(Exception e){
				return false;
			}
			
		}else{
			return false;
		}
		
	}

	public Map<String, Object> getSchoolList(Map<String, String> paraMap, SUser user) {
		
		//定义map
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 
		 String scCode = paraMap.containsKey("scCode") ? paraMap.get("scCode") : "";
		 String scName = paraMap.containsKey("scName") ? paraMap.get("scName") : "";
		 String hql = " from TSchool where recStat = '1' " ;
		 if(StringUtil.isNoNull(scCode)){
			 hql += " and scCode = '" + scCode + "'";
		 }
		 if(StringUtil.isNoNull(scName)){
			 hql += " and scName like '" + scName + "%'";
		 }
		List<TSchool> schoolList = hqlOperate.getPagedByHql(hql, TSchool.class ,
				(Integer.parseInt(paraMap.get("page")) -1)*Integer.parseInt(paraMap.get("rows")) , 
				Integer.parseInt(paraMap.get("rows")));
		jsonMap.put("total", hqlOperate.getByHql(hql).size());
		jsonMap.put("rows", schoolList);
		return jsonMap;
	}

}
