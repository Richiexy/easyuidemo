package com.easyui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * SDicinfo 字典表. 
 * @author 俞根海
 */
@JsonAutoDetect
@Entity
@Table(name="S_DICINFO")
public class SDicinfo implements java.io.Serializable {

	// Fields
	@Id
	@Column(name="FIELDNAME", length=30)
	private String fieldname;//字典字段
	
	@Id
	@Column(name="CODE", length=30)
	private String code;//字典码
	
	@Column(name="CONTANT", length=30)
	private String contant;//字典值
	
	@Column(name="MEMO", length=200)
	private String memo;//备注
	
	@Column(name="REC_STAT" , length=1)
	private String recStat;//记录状态
	
	@Column(name="CREATE_TIME" , length=20)
	private String createTime;//创建时间
	
	@Column(name="CREATE_USER" , length=10)
	private String createUser;//创建人
	
	@Column(name="MODIFY_TIME" , length=20)
	private String modifyTime;//修改时间
	
	@Column(name="MODIFY_USER" , length=10)
	private String modifyUser;//修改人

	// Constructors

	public String getFieldname() {
		return this.fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContant() {
		return this.contant;
	}

	public void setContant(String contant) {
		this.contant = contant;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRecStat() {
		return recStat;
	}

	public void setRecStat(String recStat) {
		this.recStat = recStat;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

}