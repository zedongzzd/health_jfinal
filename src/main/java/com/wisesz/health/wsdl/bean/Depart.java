package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

/**
 * 科室信息
 * 
 * @author Administrator
 *
 */
public class Depart extends Dom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 科室名称
	 */
	private String departName;

	private DepartBasic departBasic;

	private Schedual schedual;

	private Doctor doctor;

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public DepartBasic getDepartBasic() {
		return departBasic;
	}

	public void setDepartBasic(DepartBasic departBasic) {
		this.departBasic = departBasic;
	}

	public Schedual getSchedual() {
		return schedual;
	}

	public void setSchedual(Schedual schedual) {
		this.schedual = schedual;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
