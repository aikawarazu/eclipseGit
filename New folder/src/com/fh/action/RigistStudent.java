package com.fh.action;

import com.fh.dao.StudentDao;
import com.fh.dao.impl.StudentDaoImpl;
import com.fh.domain.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RigistStudent extends ActionSupport implements ModelDriven<Student> {
	
	Student student = new Student();
	
	@Override
	public String execute() throws Exception {
		
		StudentDaoImpl stuDao = new StudentDaoImpl();
		
		return SUCCESS;
	}
	
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}

}
