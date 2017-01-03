package com.fh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		System.out.println("logining...");
		return login();
	}

	private String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10);
		if (username == null) {
			String referer = request.getHeader("referer");
			if (!referer.startsWith("http://localhost:8080/JavaWebPractice/loginAction")) {
				session.setAttribute("fromUrl",referer );
			}
			
			System.out.println("fromUrl:"+request.getHeader("referer"));
			System.out.println("fromUrl,session:"+session.getAttribute("fromUrl"));
			
			System.out.println("username:"+username);
			return LOGIN;
		}
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			System.out.println("username:"+username);
			System.out.println("fromUrl:"+session.getAttribute("fromUrl"));
			if (session.getAttribute("fromUrl")==null || session.getAttribute("fromUrl")=="") {
				
				session.setAttribute("fromUrl",request.getContextPath() );
				
			}
			System.out.println(session.getId());
			return SUCCESS;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
