package com.fh.action;

import com.opensymphony.xwork2.Action;

public class HelloStruts implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("hello struts");
		return Action.SUCCESS;
	}

}
