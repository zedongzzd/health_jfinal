package com.wisesz.health.wsdl.handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.wisesz.health.common.Const;

import me.zzd.webapp.core.dom.XmlDocument;

public class WsdlHandler {

	private static String doRequest(WSDLParam _param) throws IOException {
		if (_param == null) {
			return null;
		}
		String param = _param.toString();
		URL url = new URL(Const.SZREGPLAT_WSDL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Length", Integer.toString(param.length()));
		conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		conn.setRequestMethod("POST");
		OutputStream os = conn.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
		osw.write(param);
		osw.close();
		// 获得响应状态
		int responseCode = conn.getResponseCode();
		if (HttpURLConnection.HTTP_OK == responseCode) {
			InputStream is = conn.getInputStream();
			byte[] b = new byte[1024];
			int len = 0;
			StringBuilder result = new StringBuilder();
			while ((len = is.read(b)) != -1) {
				result.append(new String(b, 0, len, "utf8"));
			}
			return result.toString();
		}
		return null;
	}

	public static class WSDLParam {
		private XmlDocument method;

		public WSDLParam(String methodName) {
			this.method = new XmlDocument(methodName).addAttr("xmlns", "http://new.webservice.namespace");
		}

		public WSDLParam addParam(String name, String value) {
			this.method.addChild(new XmlDocument(name, value));
			return this;
		}

		public WSDLParam addParam(XmlDocument re) {
			this.method.addChild(re);
			return this;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(
					"<?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Body>");
			sb.append(this.method.toString());
			sb.append("</S:Body></S:Envelope>");
			return sb.toString();
		}

		public String execute() {
			try {
				return doRequest(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

	}
}
