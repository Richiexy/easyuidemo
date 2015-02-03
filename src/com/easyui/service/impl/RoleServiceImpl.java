package com.easyui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyui.model.SRole;
import com.easyui.model.SUser;
import com.easyui.service.BaseService;
import com.easyui.service.IRoleService;
import com.easyui.util.BeanUtil;
import com.easyui.util.DateUtil;
import com.easyui.util.StringUtil;

@Service("roleService")
@Transactional
public class RoleServiceImpl extends BaseService implements IRoleService  {

	
	public Map<String, Object> getRoleList(Map<String, String> paraMap, SUser user) {
		
		//定义map
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 
		 String roleid = paraMap.containsKey("roleid") ? paraMap.get("roleid") : "";
		 String rolename = paraMap.containsKey("rolename") ? paraMap.get("rolename") : "";
		 String hql = " from SRole where recStat = '1' " ;
		 if(StringUtil.isNoNull(roleid)){
			 hql += " and roleid = '" + roleid + "'";
		 }
		 if(StringUtil.isNoNull(rolename)){
			 hql += " and rolename like '" + rolename + "%'";
		 }
		List<SRole> roleList = hqlOperate.getPagedByHql(hql, SRole.class ,
				(Integer.parseInt(paraMap.get("page")) -1)*Integer.parseInt(paraMap.get("rows")) , 
				Integer.parseInt(paraMap.get("rows")));
		jsonMap.put("total", hqlOperate.getByHql(hql).size());
		jsonMap.put("rows", roleList);
		return jsonMap;
	}

	public void editRole(SRole sRole, SUser user) {

		sRole.setModifyUser(user.getUserid());
		sRole.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		SRole t_role = hqlOperate.getById(SRole.class, sRole.getKId());
		BeanUtil.copyFields(sRole, SRole.class, t_role, SRole.class);
		hqlOperate.merge(t_role);
	}

	public void addRole(SRole sRole, SUser user) {

		sRole.setCreateUser(user.getUserid());
		sRole.setCreateTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		sRole.setModifyUser(user.getUserid());
		sRole.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		hqlOperate.save(sRole);
	}

	public boolean batchDel(String keyIds) {
		if(StringUtil.isNotNull(keyIds)){
			try{
				jdbcTemplate.execute(" update S_ROLE set rec_stat='0' where k_id in( " + keyIds + " )" );
				return true;
			}catch(Exception e){
				return false;
			}
			
		}else{
			return false;
		}
		
	}

}