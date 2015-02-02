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
import com.easyui.model.SUser;
import com.easyui.service.IPrivService;
import com.easyui.util.JacksonUtil;
import com.easyui.util.StringUtil;

/**
 * @Description: 权限管理
 * @author: 俞根海
 * @date： 2015-1-28 下午2:04:39
 */
@Controller
@RequestMapping("/privController")
@SessionAttributes("user")
public class PrivController {
	
	private Logger log = LoggerFactory.getLogger(PrivController.class);

	@Autowired(required = false)
	private IPrivService privService;
	
	/**
	 * @Description: 获取学校列表
	 * @author: 俞根海
	 * @date: 2015-1-29 下午1:57:19
	 * @param paraMap
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/getPrivList")
	@ResponseBody
	public String getPrivList(@RequestParam Map<String , String > paraMap,
			@ModelAttribute("user") SUser user ,
			ModelMap modelMap ){
		 Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map
		 
		List<SPriv> privList = privService.getPrivList(paraMap , user);
		
		jsonMap.put("total", privList.size());
		jsonMap.put("rows", privList);
		log.info("获取权限列表……");
		return JacksonUtil.serializeObjectToJson(jsonMap, true);
	}
	
	/**
	 * @Description: 新增/修改
	 * @author: 俞根海
	 * @date: 2015-1-29 下午5:24:20
	 * @param school
	 * @param user
	 * @return
	 */
	@RequestMapping("/savePriv")
	public SPriv savePriv(SPriv sPriv ,
			@ModelAttribute("user") SUser user){
		if(StringUtil.isNoNull(sPriv.getKId())){
			privService.editPriv(sPriv , user);
		}else{
			privService.addPriv(sPriv , user);
		}
		
		return sPriv;
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
			
		return privService.batchDel(keyIds);
	}
}
