package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("  <form action='checkLogin' method='post'>");
		out.println("  ”√ªß√˚:<input type='text' name='uname'/><br/>");
		out.println("  √‹¬Î: <input type='password' name='upwd'/><br/>");
		out.println("  <input type='submit' value='OK'/>");
		out.println("  ");
		out.println("  </form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	//	out.close();
	}

}
