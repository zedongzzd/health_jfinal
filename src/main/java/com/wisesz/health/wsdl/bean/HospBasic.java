package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;
/**
 * 医院基本数据
 * @author Administrator
 *
 */
public class HospBasic extends Dom {

	private static final long serialVersionUID = 1L;
	/**
	 * 医院等级
	 */
	private String grade;
	/**
	 * 医院性质
	 */
	private String kind;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 医院简介
	 */
	private String intro;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
