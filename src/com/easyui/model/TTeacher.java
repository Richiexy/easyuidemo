package com.easyui.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * TStudent 教师信息表. 
 * @author 俞根海
 */
@JsonAutoDetect
@Entity
@Table(name="T_TEACHER")
public class TTeacher implements java.io.Serializable {

	// Fields
	@Id
	@Column(name="K_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
	@SequenceGenerator(name="gen",sequenceName="SEQ_ALLTABLE")
	private Integer KId;//主键
	
	@Column(name="TC_CODE" , length=20)
	private String tcCode;//学号
	
	@Column(name="TC_NAME" , length=40)
	private String tcName;//姓名
	
	@Column(name="TC_AGE")
	private Integer tcAge;//年龄
	
	@Column(name="TC_SEX" , length=1)
	private String tcSex;//性别
	
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

	// Property accessors

	public Integer getKId() {
		return this.KId;
	}

	public void setKId(Integer KId) {
		this.KId = KId;
	}

	public String getTcCode() {
		return tcCode;
	}

	public void setTcCode(String tcCode) {
		this.tcCode = tcCode;
	}

	public String getTcName() {
		return tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

	public Integer getTcAge() {
		return tcAge;
	}

	public void setTcAge(Integer tcAge) {
		this.tcAge = tcAge;
	}

	public String getTcSex() {
		return tcSex;
	}

	public void setTcSex(String tcSex) {
		this.tcSex = tcSex;
	}

	public String getRecStat() {
		return this.recStat;
	}

	public void setRecStat(String recStat) {
		this.recStat = recStat;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

}