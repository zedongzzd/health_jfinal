package com.wisesz.health.controller;

import java.io.IOException;

import com.jfinal.core.Controller;
import com.wisesz.health.wsdl.RegplatService;
import com.wisesz.health.wsdl.bean.AuthInfo;

import me.zzd.webapp.core.annotation.BindController;

@BindController(value = "/", viewPath = "/sample")
public class SimpleController extends Controller {
	public void getNews() throws IOException {
		RegplatService service = RegplatService.getService();
		renderJson(service.getNews(AuthInfo.test(), "2015-01-15", "2016-01-16"));
	}
}
