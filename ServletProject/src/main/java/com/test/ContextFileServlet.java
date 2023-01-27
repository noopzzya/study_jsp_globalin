package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContextFile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String readFile = "/WEB-INF/testFile.txt"; // 루트 : webapp
		InputStream is = getServletContext().getResourceAsStream(readFile);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		
		String str = br.readLine();
		while(str !=null) {
			out.print(str+ "<br>");
			str = br.readLine();
		}
		br.close(); // 없어도 에러 안생기지만 원칙적으로 종료
		
		out.print("</body></html>");
	}

}
