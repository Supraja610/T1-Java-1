package com.cts.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname"); // returns the value of textbox named as uname
		String password = request.getParameter("pass");
		
		
		// Some data to be shared with view page
		
		// 1. Place data in request scope
		request.setAttribute("username", uname.toUpperCase());
		request.setAttribute("pass", password.concat("Check"));
		

		// 2. Place data in session scope
		// get the session object
 		HttpSession session =  request.getSession();
		session.setAttribute("username", uname.toUpperCase());
		session.setAttribute("pass", password.concat("Check"));


		// 3. Place data in global scope
		// get the global object : ApplicationContext
		ServletContext context =  this.getServletContext();
		context.setAttribute("username", uname.toUpperCase());
		context.setAttribute("pass", password.concat("Check"));

		
		
		// 1. First way
		/*PrintWriter writer = response.getWriter();
		// check credentials
		if(uname.equals("First") && password.equals("abc")) {
			// respond back with welcome page
			writer.write("<h1>Congratulation<h1>");
			writer.write("<h2>Successfully Logged in<h2>");
		}else {
			// respond back with error page
			writer.write("<h1>Invalid Credentials<h1>");
		}*/
		
		
		//  2. Second way (Redirect)
		/*if(uname.equals("First") && password.equals("abc")) {
			// respond the welcome page
			response.sendRedirect("welcome.jsp");
		}else {
			// respond the error page
			response.sendRedirect("error.html");
		}*/
		
		// 3. forward/dispatch
		
		if(uname.equals("First") && password.equals("abc")) {
			// respond the welcome page
			this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		}else {
			// respond the error page
			this.getServletContext().getRequestDispatcher("error.html").forward(request, response);
		}
	}

}






































