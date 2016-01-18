package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

public class Hospital extends Dom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String hospName;
	private HospBasic hospBasic;
	private Depart depart;

	public static enum NotifyType {
		GetHospBasic, GetHospDepartBasic, GetHospDocBasic, GetSchedualList;
	}

	public String getHospName() {
		return hospName;
	}

	public void setHospName(String hospName) {
		this.hospName = hospName;
	}

	public HospBasic getHospBasic() {
		return hospBasic;
	}

	public void setHospBasic(HospBasic hospBasic) {
		this.hospBasic = hospBasic;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
