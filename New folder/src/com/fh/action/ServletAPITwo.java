package com.fh.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class ServletAPITwo extends ActionSupport implements ServletContextAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3161785928227461696L;
	private ServletContext context;
	
	@Override
	public String execute() throws Exception {
		ServletContext sc = context;
		sc.setAttribute("person", "xiaoming");
		ServletActionContext.getRequest().setAttribute("age","11122");
		
		System.out.println("aa2ae 1/0;x");
		
		return 1+"";
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context= context ;
	}
	
	public void doException() throws Exception{
		Map<String, String> errorMessage = new HashMap<String,String>();
		errorMessage.put("1",	"erraa");
		errorMessage.put("2",	"errbb");
		ServletActionContext.getRequest().setAttribute("errorMessage", errorMessage );
		throw new Exception();
	}

}
