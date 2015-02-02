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
 * TCourse 课程信息表. 
 * @author 俞根海
 */
@JsonAutoDetect
@Entity
@Table(name="T_COURSE")
public class TCourse implements java.io.Serializable {

	// Fields
	@Id
	@Column(name="K_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
	@SequenceGenerator(name="gen",sequenceName="SEQ_ALLTABLE")
	private Integer KId;//主键
	
	@Column(name="CO_CODE" , length=20)
	private String coCode;//课程号
	
	@Column(name="CO_NAME" , length=200)
	private String coName;//课程名
	
	@Column(name="P_K_ID")
	private Integer PKId;//先行课程号
	
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

	public String getCoCode() {
		return this.coCode;
	}

	public void setCoCode(String coCode) {
		this.coCode = coCode;
	}

	public String getCoName() {
		return this.coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public Integer getPKId() {
		return this.PKId;
	}

	public void setPKId(Integer PKId) {
		this.PKId = PKId;
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