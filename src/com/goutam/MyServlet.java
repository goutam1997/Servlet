package com.goutam;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		String command = req.getParameter("command");

		HttpSession session = req.getSession();
		session.setAttribute("command", command);

		res.sendRedirect("show");

	}
}
