package com.wisesz.health.wsdl.bean;

import java.util.Date;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

/**
 * 挂号信息
 * 
 * @author Administrator
 *
 */
public class RegInfo extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 医院信息
	 */
	private String hospName;
	/**
	 * 科室名称
	 */
	private String departName;
	/**
	 * 医生名字
	 */
	private String doctorName;
	/**
	 * 医生星级评分(0~5)
	 */
	private Integer docRate;
	/**
	 * 排班日期(2014-01-11)
	 */
	private Date workDate;

	/**
	 * 值班类别
	 */
	private WorkType workType;

	public static enum WorkType {
		上午, 下午;
	}

	/**
	 * 号源开始时间(12:00:00)
	 */
	private String startTime;
	/**
	 * 号源结束时间(12:00:00)
	 */
	private String endTime;
	/**
	 * 是否已付费
	 */
	private Boolean isPayed;

	/**
	 * 预约类型
	 */
	private RegOperType regOperType;

	public static enum RegOperType {
		// 放射检查类型
		RadCheckType {
			public RadCheckType radCheckType;

			@Override
			public RadCheckType value() {
				return radCheckType;
			}
		},
		// 体检套餐类型
		BodyCheckSet {
			public Integer bodyCheckSet;

			@Override
			public Integer value() {
				return bodyCheckSet;
			}
		};
		public abstract Object value();
	}

	public static enum RadCheckType {
		CT, MRI, CR, DR, DSA
	}

	private CliniQueChange cliniQueChange;

	public String getHospName() {
		return hospName;
	}

	public void setHospName(String hospName) {
		this.hospName = hospName;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Integer getDocRate() {
		return docRate;
	}

	public void setDocRate(Integer docRate) {
		this.docRate = docRate;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsPayed() {
		return isPayed;
	}

	public void setIsPayed(Boolean isPayed) {
		this.isPayed = isPayed;
	}

	public RegOperType getRegOperType() {
		return regOperType;
	}

	public void setRegOperType(RegOperType regOperType) {
		this.regOperType = regOperType;
	}

	public CliniQueChange getCliniQueChange() {
		return cliniQueChange;
	}

	public void setCliniQueChange(CliniQueChange cliniQueChange) {
		this.cliniQueChange = cliniQueChange;
	}

	public static enum OperType {
		AddReg, DelReg, ModReg;
	}

	@Override
	public XmlDocument toDocument() {
		// TODO Auto-generated method stub
		return null;
	}

}
