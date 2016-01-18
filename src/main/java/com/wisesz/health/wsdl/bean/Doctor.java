package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

public class Doctor extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String doctorName;
	private DocBasic docBasic;
	private Schedual schedual;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public DocBasic getDocBasic() {
		return docBasic;
	}

	public void setDocBasic(DocBasic docBasic) {
		this.docBasic = docBasic;
	}

	public Schedual getSchedual() {
		return schedual;
	}

	public void setSchedual(Schedual schedual) {
		this.schedual = schedual;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
