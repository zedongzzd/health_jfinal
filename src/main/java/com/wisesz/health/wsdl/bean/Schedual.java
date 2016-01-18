package com.wisesz.health.wsdl.bean;

import java.math.BigDecimal;

import com.wisesz.health.wsdl.bean.RegInfo.WorkType;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

public class Schedual extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 排班日期
	 */
	private String workDate;
	private WorkType workType;
	/**
	 * 排班状态
	 */
	private WorkStatus workStatus;

	public static enum WorkStatus {
		正常, 停诊, 停诊但保留预约;
	}

	/**
	 * 专家费
	 */
	private BigDecimal expertFee;
	/**
	 * 备注
	 */
	private String remark;

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

	public WorkStatus getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(WorkStatus workStatus) {
		this.workStatus = workStatus;
	}

	public BigDecimal getExpertFee() {
		return expertFee;
	}

	public void setExpertFee(BigDecimal expertFee) {
		this.expertFee = expertFee;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
