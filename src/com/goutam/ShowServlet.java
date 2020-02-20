package com.goutam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();

		String command = (String) session.getAttribute("command");
		out.println(command);

		String[] word = command.split(" ");

		for (int i = 0; i < word.length; i++) {
			if (word[i].equalsIgnoreCase("put")) {
				i++;
				String type = word[i];
				i++;
				// System.out.println("Type: "+type);
				String ans = "";
				while (i < word.length && !(word[i].equalsIgnoreCase("put") || word[i].equalsIgnoreCase("get"))) {
					if (word[i].startsWith("/"))
						ans += word[i].substring(1);
					else
						ans += word[i] + " ";
					i++;
				}
				i--;
				Server.put(type, ans);

			} else if (word[i].equalsIgnoreCase("get")) {
				i++;

				if (Server.exists(word[i]))
					out.println(word[i] + " -> " + Server.get(word[i]));
				else {
					session.setAttribute("type", word[i]);
					res.sendRedirect("error");
				}
					
			}
		}
	}
}
