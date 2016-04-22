package cn.javass.chapter4.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

public class HelloWorldLastModifiedCacheController extends AbstractController
		implements LastModified {

	private long lastModified;
	
	@Override
	public long getLastModified(HttpServletRequest request) {
		lastModified = System.currentTimeMillis();
		return 111111111111111l;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.getWriter().write("<a href=''>this</a>");
		return null;
	}

}
