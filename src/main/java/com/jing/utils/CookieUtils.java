package com.jing.utils;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

public class CookieUtils {

	public static Cookie getCookieByName(Cookie[] cookies, String name) {
		if (cookies != null && cookies.length != 0 && name != null && name.length() != 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}
	
	public static void delete(String name) {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		Cookie cookie = getCookieByName(cookies, name);
		if (cookie != null) {
			cookie.setValue(null);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			ServletActionContext.getResponse().addCookie(cookie);
		}
	}

}
