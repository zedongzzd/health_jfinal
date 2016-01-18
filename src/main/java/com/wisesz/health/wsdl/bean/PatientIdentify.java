package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

public class PatientIdentify extends Dom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sn;
	private String idCard;
	private Other other;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Other getOther() {
		return other;
	}

	public void setOther(Other other) {
		this.other = other;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}
}
