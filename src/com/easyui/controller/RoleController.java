package com.easyui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.easyui.model.SPriv;
import com.easyui.model.SRole;
import com.easyui.model.SUser;
import com.easyui.service.IRoleService;
import com.easyui.util.JacksonUtil;
import com.easyui.util.StringUtil;

/**
 * @Description: 角色管理
 * @author: 俞根海
 * @date： 2015-1-28 下午2:04:39
 */
@Controller
@RequestMapping("/roleController")
@SessionAttributes("user")
public class RoleController {
	
	private Logger log = LoggerFactory.getLogger(RoleController.class);

	@Autowired(required = false)
	private IRoleService roleService;
	
	/**
	 * @Description: 获取学校列表
	 * @author: 俞根海
	 * @date: 2015-1-29 下午1:57:19
	 * @param paraMap
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/getRoleList")
	@ResponseBody
	public String getPrivList(@RequestParam Map<String , String > paraMap,
			@ModelAttribute("user") SUser user ,
			ModelMap modelMap ){
		 Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map
		 
		List<SRole> privList = roleService.getRoleList(paraMap , user);
		
		jsonMap.put("total", privList.size());
		jsonMap.put("rows", privList);
		log.info("获取角色列表……");
		return JacksonUtil.serializeObjectToJson(jsonMap, true);
	}
	
	/**
	 * @Description: 新增/修改
	 * @author: 俞根海
	 * @date: 2015-1-29 下午5:24:20
	 * @param sRole
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveRole")
	public SRole saveRole(SRole sRole ,
			@ModelAttribute("user") SUser user){
		if(StringUtil.isNoNull(sRole.getKId())){
			roleService.editRole(sRole , user);
		}else{
			roleService.addRole(sRole , user);
		}
		
		return sRole;
	}
	
	/**
	 * @Description: 批量删除
	 * @author: 俞根海
	 * @date: 2015-1-29 下午6:58:49
	 * @param keyIds
	 * @param user
	 * @return
	 */
	@RequestMapping("/batchDel")
	@ResponseBody
	public boolean batchDel(String keyIds,
			@ModelAttribute("user") SUser user){
			
		return roleService.batchDel(keyIds);
	}
}
