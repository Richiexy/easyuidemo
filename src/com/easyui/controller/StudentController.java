package com.easyui.controller;

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
import com.easyui.model.TStudent;
import com.easyui.service.IStudentService;
import com.easyui.util.JacksonUtil;
import com.easyui.util.StringUtil;

/**
 * @Description: 学生管理
 * @author: 俞根海
 * @date： 2015-1-28 下午2:04:39
 */
@Controller
@RequestMapping("/studentController")
@SessionAttributes("user")
public class StudentController {
	
	private Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired(required = false)
	private IStudentService studentService;
	
	/**
	 * @Description: 获取学生列表
	 * @author: 俞根海
	 * @date: 2015-1-29 下午1:57:19
	 * @param paraMap
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/getStudentList")
	@ResponseBody
	public String getStudentList(@RequestParam Map<String , String > paraMap,
			@ModelAttribute("user") SUser user ,
			ModelMap modelMap ){
		
		 Map<String, Object> jsonMap = studentService.getStudentList(paraMap , user);
		
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
	@RequestMapping("/saveStudent")
	public TStudent saveStudent(TStudent teacher ,
			@ModelAttribute("user") SUser user){
		if(StringUtil.isNoNull(teacher.getKId())){
			studentService.editStudent(teacher , user);
		}else{
			studentService.addStudent(teacher , user);
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
			
		return studentService.batchDel(keyIds);
	}
	
	/**
	 * @Description: 所属班级下拉列表
	 * @author: 俞根海
	 * @date: 2015-2-3 下午10:36:02
	 * @param paraMap
	 * @param user
	 * @return
	 */
	@RequestMapping("/getClassComboData")
	@ResponseBody
	public String getClassComboData(@RequestParam Map<String , String > paraMap ,
			@ModelAttribute("user") SUser user ){
		
		List<Map<String, String>> mapList = studentService.getClassComboData(paraMap , user);
		
		return JacksonUtil.serializeObjectToJson(mapList, true);
	}
}
