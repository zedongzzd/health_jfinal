package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

/**
 * 病人信息
 * 
 * @author Administrator
 *
 */
public class PatientInfo extends Dom {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 身份证号码
	 */
	private String idCard;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 性别
	 */
	private Sex sex;

	public static enum Sex {
		男, 女;
	}

	/**
	 * 生日（2014-05-16）
	 */
	private String birth;
	/**
	 * 付费方式
	 */
	private InsureType insureType;

	public static enum InsureType {
		自费, 市民卡, 园区医保;
	}

	/**
	 * 付款费用
	 */
	private Integer payAccount;
	/**
	 * 家庭组标识
	 */
	private String familyCard;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex.toString();
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getInsureType() {
		return insureType.toString();
	}

	public void setInsureType(InsureType insureType) {
		this.insureType = insureType;
	}

	public String getPayAccount() {
		return payAccount.toString();
	}

	public void setPayAccount(Integer payAccount) {
		this.payAccount = payAccount;
	}

	public String getFamilyCard() {
		return familyCard;
	}

	public void setFamilyCard(String familyCard) {
		this.familyCard = familyCard;
	}

	@Override
	public XmlDocument toDocument() {
		return new XmlDocument("PatientInfo").addChild("IdCard", getIdCard()).addChild("Name", getName())
				.addChild("Phone", getPhone()).addChild("Sex", getSex()).addChild("Birth", getBirth())
				.addChild("InsureType", getInsureType()).addChild("PayAccount", getPayAccount())
				.addChild("IdCard", getFamilyCard());
	}

}
