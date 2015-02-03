package com.easyui.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.easyui.model.SUser;
import com.easyui.service.ISchoolService;
import com.easyui.service.IUserService;

/**
 * @Description: 系统管理菜单跳转
 * @author: 俞根海
 * @date： 2015-1-28 下午2:04:39
 */
@Controller
@RequestMapping("/sysController")
@SessionAttributes("user")
public class SysController {

	@Autowired(required = false)
	private IUserService userService;
	
	@Autowired(required = false)
	private ISchoolService schoolService;
	
	/**
	 * @Description: 基本设置测试
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:16:05
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/schoolMgr")
	public String schoolMgr(ModelMap model){
		
//		传值到前台，然后c标签循环生成表格有一些问题
//		List<TSchool> schoolList = schoolService.findAllSchool();
//		model.put("schoolList", schoolList);
		
		return "xtgl/schoolMgr";
	}
	
	/**
	 * @Description: 用户管理
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:16:39
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/userMgr")
	public String userMgr(ModelMap model){
		
		List<SUser> userList = new ArrayList<SUser>();
		
		SUser user = userService.getByUserId("admin");
		userList.add(user);
		model.put("userList", userList);
		
		return "xtgl/userMgr";
	}
	
	/**
	 * @Description: 权限管理
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:17:18
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/privMgr")
	public String privMgr(ModelMap model){
		
		
		return "xtgl/privMgr";
	}
	
	/**
	 * @Description: 角色管理
	 * @author: 俞根海
	 * @date: 2015-1-29 上午11:18:15
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/roleMgr")
	public String roleMgr(ModelMap model){
		
		
		return "xtgl/roleMgr";
	}
	
	/**
	 * @Description: 课程管理
	 * @author: 俞根海
	 * @date: 2015-2-3 下午2:49:42
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/courseMgr")
	public String courseMgr(ModelMap model){
		
		return "xtgl/courseMgr";
	}
	
	/**
	 * @Description: 教师管理
	 * @author: 俞根海
	 * @date: 2015-2-2 下午6:20:32
	 * @param model
	 * @return
	 */
	@RequestMapping("/tc/tcMgr")
	public String tcMgr(ModelMap model){
		
		
		return "tc/tcMgr";
	}
	
	/**
	 * @Description: 学生管理
	 * @author: 俞根海
	 * @date: 2015-2-2 下午6:20:56
	 * @param model
	 * @return
	 */
	@RequestMapping("/st/stMgr")
	public String stMgr(ModelMap model){
		
		
		return "st/stMgr";
	}
	
	
	@RequestMapping("/user/schoolTimeTable")
	public String schoolTimeTable(@RequestParam Map<String ,String> paraMap ,
			@ModelAttribute("user") SUser user,
			ModelMap model){
		
		String pageType = paraMap.containsKey("") ? paraMap.get("") : "";
		model.put("pageType", pageType);
		return "xtgl/schoolTimeTable";
	}
}
