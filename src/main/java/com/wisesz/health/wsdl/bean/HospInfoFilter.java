package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;
/**
 * 过滤信息
 * @author Administrator
 *
 */
public class HospInfoFilter extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OperType operType;

	/**
	 * 1. 当OperType=GetHospBasic时，请求方不应携带HospName，接收方返回多个HospName和HospBasic,但不含有Depart信息元素. 
	 * 2. 当OperType=GetHospDepartBasic，请求方应携带HospName,接收方返回指定医院的HospName和多个Depart信息元素，但不含
	 * 有HospBasic信息元素,且Depart信息元素中携带DepartName和DepartBasic，不携带Doctor元素和Schedual元素. 
	 * 3.当OperType=GetHospDocBasic，请求方应携带HospName，接收方返回指定医院的HospName和多个Depart信息元素,但不含有
	 * HospBasic信息元素，且Depart信息元素中携带DepartName和Doctor，不携带DepartBasic元素.Doctor元素携带DoctorName和
	 * DocBasic，不携带Schedual信息元素
	 * 4.当OperType=GetSchedualList，请求方应携带HospName，接收方返回指定医院的HospName和多个Depart信息元素，
	 * 但不含有HospBasic信息元素。Depart信息元素中携带DepartName和Doctor，不携带DepartBasic元素.
	 * Doctor元素携带DoctorName和Schedual，不携带DocBasic信息元素。
	 * 
	 * @author Administrator
	 *
	 */
	public static enum OperType {
		GetHospBasic, GetHospDepartBasic, GetHospDocBasic, GetSchedualList
	}

	/**
	 * 医院名
	 */
	private String hospName;
	/**
	 * 科室名
	 */
	private String departName;
	/**
	 * 医生名
	 */
	private String doctorName;
	/**
	 * 排班起始日期（如 2012-12-20）
	 */
	private String beginDate;

	private String endDate;

	public OperType getOperType() {
		return operType;
	}

	public void setOperType(OperType operType) {
		this.operType = operType;
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

	@Override
	public XmlDocument toDocument() {
		// TODO Auto-generated method stub
		return null;
	}

}
