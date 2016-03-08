package com.fh.jsp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fh.domain.Person;

/**
 * Servlet implementation class HelloStruts
 */
@WebServlet("/HelloStruts")
public class HelloStruts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> users= new ArrayList<Person>();
		Person person = new Person();
		person.setName("bob");
		users.add(person);
		request.setAttribute("users", users);
		System.out.println("hello.servlet");
		request.getRequestDispatcher("/WEB-INF/jsp/GetAttr.jsp").forward(request, response);
		
	}

}
