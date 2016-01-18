package com.wisesz.health.wsdl.bean;

import java.math.BigDecimal;

import com.wisesz.health.wsdl.bean.PatientInfo.Sex;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

/**
 * 科室基本信息
 * 
 * @author Administrator
 *
 */
public class DepartBasic extends Dom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 科室类别
	 */
	private DepartType departType;

	public static enum DepartType {
		普通, 专家, 普通和专家;
	}

	/**
	 * 科室简介
	 */
	private String departIntro;
	/**
	 * 放号限额
	 */
	private Integer limited;
	/**
	 * 挂号费
	 */
	private BigDecimal registryFee;
	/**
	 * 门诊费
	 */
	private BigDecimal clinicFee;
	/**
	 * 科室性别限制
	 */
	private Sex departSex;
	/**
	 * 儿科年龄限制
	 */
	private Integer childAge;

	public DepartType getDepartType() {
		return departType;
	}

	public void setDepartType(DepartType departType) {
		this.departType = departType;
	}

	public String getDepartIntro() {
		return departIntro;
	}

	public void setDepartIntro(String departIntro) {
		this.departIntro = departIntro;
	}

	public Integer getLimited() {
		return limited;
	}

	public void setLimited(Integer limited) {
		this.limited = limited;
	}

	public BigDecimal getRegistryFee() {
		return registryFee;
	}

	public void setRegistryFee(BigDecimal registryFee) {
		this.registryFee = registryFee;
	}

	public BigDecimal getClinicFee() {
		return clinicFee;
	}

	public void setClinicFee(BigDecimal clinicFee) {
		this.clinicFee = clinicFee;
	}

	public Sex getDepartSex() {
		return departSex;
	}

	public void setDepartSex(Sex departSex) {
		this.departSex = departSex;
	}

	public Integer getChildAge() {
		return childAge;
	}

	public void setChildAge(Integer childAge) {
		childAge = childAge;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
