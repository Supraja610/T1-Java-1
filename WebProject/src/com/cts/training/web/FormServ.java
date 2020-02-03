package com.cts.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServ
 */
@WebServlet("/FormServ")
public class FormServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// access the form data
		String uname = request.getParameter("uname"); // returns the value of textbox named as uname
		String email = request.getParameter("email");
		
		PrintWriter writer = response.getWriter();
		writer.write("<h1>NAME : " + uname + "</h1>");
		writer.write("<h1>EMAIL: " + email + "</h1>");
		
	}
	

}












