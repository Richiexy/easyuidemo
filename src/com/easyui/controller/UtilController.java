package com.easyui.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.easyui.model.SUser;
import com.easyui.service.HqlOperate;
import com.easyui.util.JacksonUtil;

/**
 * @Description: 系统工具类
 * @author: 俞根海
 * @date： 2015-1-28 下午2:04:39
 */
@Controller
@RequestMapping("/utilController")
@SessionAttributes("user")
public class UtilController {

	@Autowired(required=false)
	protected HqlOperate hqlOperate;
	
	@Autowired(required=false)
	protected HibernateTemplate hibernateTemplate;
	
	@Autowired(required=false)
	protected JdbcTemplate jdbcTemplate;
	
	/**
	 * @Description: 加载字典表
	 * @author: 俞根海
	 * @date: 2015-2-3 下午9:58:51
	 * @param fieldName
	 * @param showParam
	 * @return
	 */
	@RequestMapping("/getDicInfo")
	@ResponseBody
	public String getDicInfo(@RequestParam Map<String , String > paraMap ,
			@ModelAttribute("user") SUser user ){
		
		String fieldName = paraMap.get("fieldName");
		
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("value", "");
		map.put("text", "--请选择--");
		mapList.add(map);

		String sql = "select code,contant from S_DICINFO where rec_stat='1' and fieldname = '"+ fieldName + "' order by code";
		List<Map<String, String>> list = jdbcTemplate.query(sql,
				new RowMapper<Map<String, String>>() {
					public Map<String, String> mapRow(ResultSet rs, int index)
							throws SQLException {
						Map<String, String> map = new HashMap<String, String>();
						map.put("value", rs.getString(1));
						map.put("text", rs.getString(2));
						return map;
					}
				});

		mapList.addAll(list);
		
		return JacksonUtil.serializeObjectToJson(mapList, true);
	}
}
