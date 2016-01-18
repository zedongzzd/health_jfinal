package com.wisesz.health.wsdl.bean;

/**
 * 临床变更记录
 * 
 * @author Administrator
 *
 */
public class CliniQueChange {
	/**
	 * 转出机构代码
	 */
	private String outHospitalCode;
	/**
	 * 转出机构名称
	 */
	private String outHospitalName;
	/**
	 * 转出科室代码
	 */
	private String fromDepartCode;
	/**
	 * 转出科室名称
	 */
	private String fromDepartName;
	/**
	 * 转出医生代码
	 */
	private String fromDoctorCode;
	/**
	 * 转出医生名称
	 */
	private String fromDoctorName;
	/**
	 * 检查（验）单号
	 */
	private String checkCode;
	/**
	 * 检查（验）操作人
	 */
	private String checkerName;
	/**
	 * 检查（验）时间 (2010-04-17T09:00:00)
	 */
	private String checkTime;
	/**
	 * 转诊原因
	 */
	private String cliniQueChangeReason;
	/**
	 * 病情描述
	 */
	private String medicalRecord;
	/**
	 * 初步判断
	 */
	private String preDiagonsis;

	public String getOutHospitalCode() {
		return outHospitalCode;
	}

	public void setOutHospitalCode(String outHospitalCode) {
		this.outHospitalCode = outHospitalCode;
	}

	public String getOutHospitalName() {
		return outHospitalName;
	}

	public void setOutHospitalName(String outHospitalName) {
		this.outHospitalName = outHospitalName;
	}

	public String getFromDepartCode() {
		return fromDepartCode;
	}

	public void setFromDepartCode(String fromDepartCode) {
		this.fromDepartCode = fromDepartCode;
	}

	public String getFromDepartName() {
		return fromDepartName;
	}

	public void setFromDepartName(String fromDepartName) {
		this.fromDepartName = fromDepartName;
	}

	public String getFromDoctorCode() {
		return fromDoctorCode;
	}

	public void setFromDoctorCode(String fromDoctorCode) {
		this.fromDoctorCode = fromDoctorCode;
	}

	public String getFromDoctorName() {
		return fromDoctorName;
	}

	public void setFromDoctorName(String fromDoctorName) {
		this.fromDoctorName = fromDoctorName;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getCheckerName() {
		return checkerName;
	}

	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCliniQueChangeReason() {
		return cliniQueChangeReason;
	}

	public void setCliniQueChangeReason(String cliniQueChangeReason) {
		this.cliniQueChangeReason = cliniQueChangeReason;
	}

	public String getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(String medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public String getPreDiagonsis() {
		return preDiagonsis;
	}

	public void setPreDiagonsis(String preDiagonsis) {
		this.preDiagonsis = preDiagonsis;
	}
}
