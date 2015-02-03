package com.easyui.controller;

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
import com.easyui.model.TCourse;
import com.easyui.service.ICourseService;
import com.easyui.util.JacksonUtil;
import com.easyui.util.StringUtil;

/**
 * @Description: 课程管理
 * @author: 俞根海
 * @date： 2015-1-28 下午2:04:39
 */
@Controller
@RequestMapping("/courseController")
@SessionAttributes("user")
public class CourseController {
	
	private Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired(required = false)
	private ICourseService courseService;
	
	/**
	 * @Description: 获取学校列表
	 * @author: 俞根海
	 * @date: 2015-1-29 下午1:57:19
	 * @param paraMap
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/getCourseList")
	@ResponseBody
	public String getCourseList(@RequestParam Map<String , String > paraMap,
			@ModelAttribute("user") SUser user ,
			ModelMap modelMap ){
		 
		 Map<String, Object> jsonMap = courseService.getCourseList(paraMap , user);
		
		log.info("获取课程列表……");
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
	@RequestMapping("/saveCourse")
	public TCourse saveCourse(TCourse tCourse ,
			@ModelAttribute("user") SUser user){
		if(StringUtil.isNoNull(tCourse.getKId())){
			courseService.editCourse(tCourse , user);
		}else{
			courseService.addCourse(tCourse , user);
		}
		
		return tCourse;
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
			
		return courseService.batchDel(keyIds);
	}
}
