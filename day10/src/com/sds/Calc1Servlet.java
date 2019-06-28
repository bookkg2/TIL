package com.sds;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc1Servlet
 */
@WebServlet({ "/Calc1Servlet", "/calc1" })
public class Calc1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int result = n1 + n2;
		Writer out = response.getWriter();
		out.write("<h1>"+result+"</h1>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int result = n1 + n2;
		
		Writer out = resp.getWriter();
		out.write(result+"");
		out.close();
	}
	
	

}



