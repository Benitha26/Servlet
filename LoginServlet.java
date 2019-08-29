package com.quinnox.basics.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.basics.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("u");
		String password=request.getParameter("p");
		
		Base64.Encoder encoder=Base64.getEncoder();
		String normalString=password;
		String encodedString=encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		
		if(LoginDao.validate(email,password)){
			RequestDispatcher rd=request.getRequestDispatcher("viewCustomers.jsp");
			rd.forward(request, response);
			pw.print("Login Successful");
		} 
		else
		{
			pw.print("Sorry username or password error");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
