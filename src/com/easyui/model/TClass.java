package com.easyui.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * TClass 班级信息表. 
 * @author 俞根海
 */
@JsonAutoDetect
@Entity
@Table(name="T_CLASS")
public class TClass implements java.io.Serializable {

	// Fields
	@Id
	@Column(name="K_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
//	@SequenceGenerator(name="gen",sequenceName="SEQ_ALLTABLE")
	private Integer KId;//主键
	
	@Column(name="CL_CODE" , length=20)
	private String clCode;//班级编号
	
	@Column(name="CL_NAME" , length=200)
	private String clName;//班级名称
	
	@Column(name="SC_CODE" , length=20)
	private String scCode;//所属学校
	
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

	public String getClCode() {
		return this.clCode;
	}

	public void setClCode(String clCode) {
		this.clCode = clCode;
	}

	public String getClName() {
		return this.clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
	}

	public String getScCode() {
		return this.scCode;
	}

	public void setScCode(String scCode) {
		this.scCode = scCode;
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