package com.bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VisitList")
public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// db 연결 시 예외처리 필수!
		try {
			out.println("<html>");
			out.println("<head><title>방명록 리스트</title></head>");
			out.println("<body>");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select no, writer, memo, regdate ");
			sql.append("from visit ");
			sql.append("order by no desc ");
			
			// 데이터베이스 연결
			Connection con = null;
			PreparedStatement pstmt = null;
			
			// 결과 집합
			ResultSet rs = null;
			
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
				pstmt = con.prepareStatement(sql.toString());				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					// 괄호 안 db 필드명
					int no = rs.getInt("no");
					String writer = rs.getString("writer");
					String memo = rs.getString("memo");
					java.sql.Date regdate = rs.getDate("regdate");
					
					out.println("<table align=center width=500 border=1>");
					
					out.println("<tr>");
					
					out.println("<th width=50>번호</th>");
					out.println("<td width=50 align=center>"+no+"</td>");
					
					out.println("<th width=70>작성자</th>");
					out.println("<td width=180 align=center>"+writer+"</td>");
					
					out.println("<th width=50>날짜</th>");
					out.println("<td width=100 align=center>"+regdate+"</td>");
					
					out.println("</tr>");
					
					out.println("<tr>");
					out.println("<th width=50>내용</th>");
					out.println("<td colspan=5>&nbsp;"+ "<textarea row=3 cols=50>"+ memo +"</textarea></td>");
					out.println("</tr>");
					
					out.println("</table>");
					out.println("<p>");
				}
				
			} catch (SQLException ss) {
				ss.printStackTrace();
				
			} catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			} finally { // 데이터베이스 연결 된 객체 수 만큼
				
				try {
					if(rs != null) rs.close();
				} catch (SQLException sse) {
					sse.printStackTrace();
				}
				
				try {
					if(pstmt != null) pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
				
				try {
					if(con != null) con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			
			out.println("<p align=center><a href=/bbs/write.html>글쓰기</a></p>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (Exception e) {
			
		} finally {
			out.close();
		}	
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
