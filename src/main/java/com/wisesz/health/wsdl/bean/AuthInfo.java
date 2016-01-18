package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;
/**
 * 身份认证
 * @author Administrator
 *
 */
public class AuthInfo extends Dom {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;

	public AuthInfo(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public static AuthInfo test() {
		return new AuthInfo("test", "test");
	}

	@Override
	public XmlDocument toDocument() {
		XmlDocument document = new XmlDocument("AuthInfo");
		document.addChildren(new XmlDocument("UserName", userName), new XmlDocument("Password", password));
		return document;
	}

}
