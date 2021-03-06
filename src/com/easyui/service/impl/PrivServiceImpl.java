package com.easyui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyui.model.SPriv;
import com.easyui.model.SUser;
import com.easyui.model.TCourse;
import com.easyui.service.BaseService;
import com.easyui.service.IPrivService;
import com.easyui.util.BeanUtil;
import com.easyui.util.DateUtil;
import com.easyui.util.StringUtil;

@Service("privService")
@Transactional
public class PrivServiceImpl extends BaseService implements IPrivService  {

	
	public Map<String, Object> getPrivList(Map<String, String> paraMap, SUser user) {
		
		 //定义map
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 
		 String privid = paraMap.containsKey("privid") ? paraMap.get("privid") : "";
		 String privname = paraMap.containsKey("privname") ? paraMap.get("privname") : "";
		 String hql = " from SPriv where recStat = '1' " ;
		 if(StringUtil.isNoNull(privid)){
			 hql += " and privid = '" + privid + "'";
		 }
		 if(StringUtil.isNoNull(privname)){
			 hql += " and privname like '" + privname + "%'";
		 }
		List<SPriv> privList = hqlOperate.getPagedByHql(hql, SPriv.class ,
				(Integer.parseInt(paraMap.get("page")) -1)*Integer.parseInt(paraMap.get("rows")) , 
				Integer.parseInt(paraMap.get("rows")));
		jsonMap.put("total", hqlOperate.getByHql(hql).size());
		jsonMap.put("rows", privList);
		return jsonMap;
	}

	public void editPriv(SPriv sPriv, SUser user) {

		sPriv.setModifyUser(user.getUserid());
		sPriv.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		SPriv t_priv = hqlOperate.getById(SPriv.class, sPriv.getKId());
		BeanUtil.copyFields(sPriv, SPriv.class, t_priv, SPriv.class);
		hqlOperate.merge(t_priv);
	}

	public void addPriv(SPriv sPriv, SUser user) {

		sPriv.setCreateUser(user.getUserid());
		sPriv.setCreateTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		sPriv.setModifyUser(user.getUserid());
		sPriv.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		hqlOperate.save(sPriv);
	}

	public boolean batchDel(String keyIds) {
		if(StringUtil.isNotNull(keyIds)){
			try{
				jdbcTemplate.execute(" update S_PRIV set rec_stat='0' where k_id in( " + keyIds + " )" );
				return true;
			}catch(Exception e){
				return false;
			}
			
		}else{
			return false;
		}
		
	}

}