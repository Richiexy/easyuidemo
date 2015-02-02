package com.easyui.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyui.model.SUser;
import com.easyui.service.BaseService;
import com.easyui.service.IUserService;
import com.easyui.util.BeanUtil;
import com.easyui.util.DateUtil;
import com.easyui.util.StringUtil;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseService implements IUserService  {

	
	public SUser getByUserId(String userid) {
		SUser user = hqlOperate.getByHqlFirst(" from SUser where userid = ? ", SUser.class, userid);
		return user;
	}

	public List<SUser> getUserList(Map<String, String> paraMap, SUser user) {
		
		 String userid = paraMap.containsKey("userid") ? paraMap.get("userid") : "";
		 String username = paraMap.containsKey("username") ? paraMap.get("username") : "";
		 String hql = " from SUser where recStat = '1' " ;
		 if(StringUtil.isNoNull(userid)){
			 hql += " and userid = '" + userid + "'";
		 }
		 if(StringUtil.isNoNull(username)){
			 hql += " and username like '" + username + "%'";
		 }
		List<SUser> userList = hqlOperate.getByHql(hql, SUser.class);
		return userList;
	}

	public boolean batchDel(String keyIds) {
		if(StringUtil.isNotNull(keyIds)){
			try{
				jdbcTemplate.execute(" update S_USER set rec_stat='0' where k_id in( " + keyIds + " )" );
				return true;
			}catch(Exception e){
				return false;
			}
			
		}else{
			return false;
		}
		
	}

	public void editUser(SUser tmpUser, SUser user) {

		tmpUser.setModifyUser(user.getUserid());
		tmpUser.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		SUser t_user = hqlOperate.getById(SUser.class, tmpUser.getKId());
		BeanUtil.copyFields(tmpUser, SUser.class, t_user, SUser.class);
		hqlOperate.merge(t_user);
	}

	public void addUser(SUser tmpUser, SUser user) {
		
		tmpUser.setCreateUser(user.getUserid());
		tmpUser.setCreateTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		tmpUser.setModifyUser(user.getUserid());
		tmpUser.setModifyTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		hqlOperate.save(tmpUser);
		
	}

}
