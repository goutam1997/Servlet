package com.goutam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ErrorServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		
		String type = (String) session.getAttribute("type");
		
		out.print("<html>");
		out.print("<title> Error </title>");
		out.print("<body bgcolor='red'>");
		out.print("Value Does Not Exist For " + type);
		out.print("</body></html>");
	}

}
