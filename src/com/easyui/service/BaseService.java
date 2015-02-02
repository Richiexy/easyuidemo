package com.easyui.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;


/**
 * @Description: 学校接口
 * @author: 俞根海
 * @date： 2015-1-29 上午11:22:16
 */
public abstract class BaseService {

	@Autowired(required=false)
	protected HqlOperate hqlOperate;
	
	@Autowired(required=false)
	protected HibernateTemplate hibernateTemplate;
	
	@Autowired(required=false)
	protected JdbcTemplate jdbcTemplate;
	
	protected Logger log = LoggerFactory.getLogger(BaseService.class);
}
