package com.wisesz.health.wsdl.bean;

import me.zzd.webapp.core.dom.Dom;
import me.zzd.webapp.core.dom.XmlDocument;

/**
 * 预约来源
 * 
 * @author Administrator
 *
 */
public class RegFrom extends Dom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 预约途径
	 */
	private RegVia regVia;

	public static enum RegVia {
		WEB_12320 {
			@Override
			public String value() {
				return null;
			}
		},
		WEB_guahao {
			@Override
			public String value() {
				return null;
			}
		},
		WEB_yidongshenghuo {
			@Override
			public String value() {
				return null;
			}
		},
		PHONE_app {
			@Override
			public String value() {
				return null;
			}
		},
		PHONE_wap {
			@Override
			public String value() {
				return null;
			}
		},
		WEIXIN_12320 {
			@Override
			public String value() {
				return null;
			}
		},
		PHONE {
			@Override
			public String value() {
				return null;
			}
		},
		ZHENGJIEYUYUE {
			@Override
			public String value() {
				return null;
			}
		},
		SHUANGXIANGYUYUE {
			@Override
			public String value() {
				return null;
			}
		},
		ZIDONGJIYUYUE {
			@Override
			public String value() {
				return null;
			}
		},
		TV {
			@Override
			public String value() {
				return null;
			}
		};
		public abstract String value();
	}

	/**
	 * 预约前端服务提供商标识
	 */
	private String vendor;
	/**
	 * 操作员标识
	 */
	private String operator;

	public RegVia getRegVia() {
		return regVia;
	}

	public void setRegVia(RegVia regVia) {
		this.regVia = regVia;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public XmlDocument toDocument() {
		return null;
	}

}
