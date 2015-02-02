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

import com.easyui.model.SUser;
import com.easyui.model.TTeacher;
import com.easyui.service.ITeacherService;
import com.easyui.service.IUserService;
import com.easyui.util.JacksonUtil;
import com.easyui.util.StringUtil;

/**
 * @Description: 教师管理
 * @author: 俞根海
 * @date： 2015-1-28 下午2:04:39
 */
@Controller
@RequestMapping("/teacherController")
@SessionAttributes("user")
public class TeacherController {
	
	private Logger log = LoggerFactory.getLogger(TeacherController.class);

	@Autowired(required = false)
	private ITeacherService teacherService;
	
	/**
	 * @Description: 获取教师列表
	 * @author: 俞根海
	 * @date: 2015-1-29 下午1:57:19
	 * @param paraMap
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/getTeacherList")
	@ResponseBody
	public String getTeacherList(@RequestParam Map<String , String > paraMap,
			@ModelAttribute("user") SUser user ,
			ModelMap modelMap ){
		 Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map
		 
		List<TTeacher> userList = teacherService.getTeacherList(paraMap , user);
		
		jsonMap.put("total", userList.size());
		jsonMap.put("rows", userList);
		log.info("获取用户列表……");
		return JacksonUtil.serializeObjectToJson(jsonMap, true);
	}
	
	/**
	 * @Description: 新增/修改
	 * @author: 俞根海
	 * @date: 2015-1-29 下午5:24:20
	 * @param teacher
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveTeacher")
	public TTeacher saveTeacher(TTeacher teacher ,
			@ModelAttribute("user") SUser user){
		if(StringUtil.isNoNull(teacher.getKId())){
			teacherService.editTeacher(teacher , user);
		}else{
			teacherService.addTeacher(teacher , user);
		}
		
		return teacher;
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
			
		return teacherService.batchDel(keyIds);
	}
}
