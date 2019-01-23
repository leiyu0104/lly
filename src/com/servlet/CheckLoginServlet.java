package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.Md5;
@WebServlet("/checkLogin")
public class CheckLoginServlet extends HttpServlet 
{

	@Override
	public void service( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		 req.setCharacterEncoding("utf-8");
		 resp.setContentType("text/html;charset=utf-8");
		 PrintWriter out=resp.getWriter();
		 String uname=null!=req.getParameter("uname")?req.getParameter("uname"):"";
		 String upwd=null!=req.getParameter("upwd")?req.getParameter("upwd"):"";
		 String mipwd=Md5.tomd5(upwd);
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/xupt", "root", "mysql");
			 PreparedStatement ps=con.prepareStatement("select * from admin where uname=? and upwd=? limit 1");
			 ps.setString(1, uname);
			 ps.setString(2, mipwd);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next())
			 {
				 //用相对路径,,调用SuccessServlet对像的service方法，将当前页面的内容发给对方
				  RequestDispatcher rd=req.getRequestDispatcher("success");
				  rd.forward(req, resp);
				  
			 }else
			 {
				 out.println("*********************************************");
				   RequestDispatcher rd=req.getRequestDispatcher("index");
				  rd.include(req, resp);
				  out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$44");
			 }
			 con.close();
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 out.close();

	}

}
