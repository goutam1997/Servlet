package com.goutam;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String command = request.getParameter("command");

		HttpSession session = request.getSession();
		session.setAttribute("command", command);

		response.sendRedirect("show");

	}
}
