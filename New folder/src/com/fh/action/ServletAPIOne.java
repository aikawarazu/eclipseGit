package com.fh.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ServletAPIOne extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3161785928227461696L;
	

	@Override
	public String execute() throws Exception {
		ServletContext sc = ServletActionContext.getServletContext();
		sc.setAttribute("person", "xiaoming");
		ServletActionContext.getRequest().setAttribute("age","122");
		
		System.out.println("aaa");
		return SUCCESS;
	}
	
}
