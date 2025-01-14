package com.modirum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Display html type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Forward the request to page link.html
		request.getRequestDispatcher("link.html").include(request, response);

		// Delete the cookie
		Cookie ck = new Cookie("name", "");
		ck.setMaxAge(0);
		response.addCookie(ck);

		out.print("You are successfully logged out!");
	}
}
