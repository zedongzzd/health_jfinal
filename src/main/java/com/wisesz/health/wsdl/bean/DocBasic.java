package com.wisesz.health.wsdl.bean;

import java.math.BigDecimal;

import com.wisesz.health.wsdl.bean.PatientInfo.Sex;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

/**
 * 医生基本信息
 * 
 * @author Administrator
 *
 */
public class DocBasic extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sex docSex;
	/**
	 * 医生职称
	 */
	private String docRank;
	/**
	 * 医生星级评分
	 */
	private Long docRate;
	/**
	 * 医生简介
	 */
	private String doctorInro;
	/**
	 * 医生特长
	 */
	private String docMajor;
	/**
	 * 是否专家
	 */
	private Boolean isExpert;
	/**
	 * 挂号费
	 */
	private BigDecimal registryFee;
	/**
	 * 门诊费
	 */
	private BigDecimal clinicFee;
	/**
	 * 医生照片链接
	 */
	private String docPhotoURL;

	public Sex getDocSex() {
		return docSex;
	}

	public void setDocSex(Sex docSex) {
		this.docSex = docSex;
	}

	public String getDocRank() {
		return docRank;
	}

	public void setDocRank(String docRank) {
		this.docRank = docRank;
	}

	public Long getDocRate() {
		return docRate;
	}

	public void setDocRate(Long docRate) {
		this.docRate = docRate;
	}

	public String getDoctorInro() {
		return doctorInro;
	}

	public void setDoctorInro(String doctorInro) {
		this.doctorInro = doctorInro;
	}

	public String getDocMajor() {
		return docMajor;
	}

	public void setDocMajor(String docMajor) {
		this.docMajor = docMajor;
	}

	public Boolean getIsExpert() {
		return isExpert;
	}

	public void setIsExpert(Boolean isExpert) {
		this.isExpert = isExpert;
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

	public String getDocPhotoURL() {
		return docPhotoURL;
	}

	public void setDocPhotoURL(String docPhotoURL) {
		this.docPhotoURL = docPhotoURL;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
