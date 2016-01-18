package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

public class RegInfoFilter extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 就诊起始日期（如 2012-12-20）
	 */
	private String beginDate;
	/**
	 * 就诊结束日期
	 */
	private String endDate;
	private String hospName;
	private String departName;
	private String doctorName;

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

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

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
