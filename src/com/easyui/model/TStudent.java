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
 * TStudent 学生信息表. 
 * @author 俞根海
 */
@JsonAutoDetect
@Entity
@Table(name="T_STUDENT")
public class TStudent implements java.io.Serializable {

	// Fields
	@Id
	@Column(name="K_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
//	@SequenceGenerator(name="gen",sequenceName="SEQ_ALLTABLE")
	private Integer KId;//主键
	
	@Column(name="ST_CODE" , length=20)
	private String stCode;//学号
	
	@Column(name="ST_NAME" , length=40)
	private String stName;//姓名
	
	@Column(name="ST_AGE")
	private Integer stAge;//年龄
	
	@Column(name="ST_SEX" , length=1)
	private String stSex;//性别
	
	@Column(name="CL_CODE" , length=20)
	private String clCode;//所属班级
	
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

	public String getStCode() {
		return this.stCode;
	}

	public void setStCode(String stCode) {
		this.stCode = stCode;
	}

	public String getStName() {
		return this.stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public Integer getStAge() {
		return this.stAge;
	}

	public void setStAge(Integer stAge) {
		this.stAge = stAge;
	}

	public String getStSex() {
		return this.stSex;
	}

	public void setStSex(String stSex) {
		this.stSex = stSex;
	}

	public String getClCode() {
		return this.clCode;
	}

	public void setClCode(String clCode) {
		this.clCode = clCode;
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