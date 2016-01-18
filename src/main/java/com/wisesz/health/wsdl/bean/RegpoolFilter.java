package com.wisesz.health.wsdl.bean;

import com.wisesz.health.wsdl.bean.RegInfo.WorkType;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

public class RegpoolFilter extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hospName;
	private String departName;
	private String doctorName;
	private String workDate;
	private WorkType workType;

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

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
