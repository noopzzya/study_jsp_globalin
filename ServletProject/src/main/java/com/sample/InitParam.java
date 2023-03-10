package com.sample;

/*
 * 1. ServletConfig(객체)
 * 	- ServletConfig 객체는 Container가 서블릿을 생성 할 때 생성되는 객체
 * 	- DD(web.xml)를 읽어서 이름/값의 쌍으로 된 초기 파라미터 값을 읽어서 저장
 *  - ServletConfig 객체는 servlet 객체 당 하나씩 생성
 *  - servlet에서는 getServletConfig()를 이용해서 Servlet과 관련된 ServletConfig 객체를 얻음
 *  
 * 2. ServletContext(어플리케이션 전체)
 * 	- ServletContext 객체는 web application 당 하나씩 생성
 *  - web application 전체에서 참조 할 수 있는 초기화 파라미터를 저장
 *  - Servlet에서는 getServletContext()를 이용해서 ServletContext 객체를 얻음
 *  
 *  - ServletContext, ServletConfig
 *   // ServletContext (전역으로 부를 때 사용)
 *  <context-param>
 *  	<description> 연락처 </description>
 *  	<param-name>tel</param-name>
 *  	<param-value>010-1111-1111</param-valu
 *  </context-param>
 *  // ServletConfig (지역으로 부를 때 사용)
 *  <servlet> 
 *  <servlet-name>InitParam</servlet-name>
 *  <servlet-class>com.sample.InitParam</servlet-class>
 *  <init-param>
 *  	<description> 연락처 </description>
 *  	<param-name>tel</param-name>
 *  	<param-value>010-1111-1111</param-value>
 *  </init-param>
 *  </servlet>
 *  <servlet-mapping>
 *  <servlet-name>InitParam</servlet-name>
 *  <url-pattern>/InitParam</url-pattern>
 *  </servlet-mapping>
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml 또는 어노테이션 둘 중 한 개만 실행해야 함
// web.xml 실행 시 어노테이션 주석 처리
@WebServlet(name = "InitParam", urlPatterns = {"/InitParam"}, // 전역
initParams = { // 어노테이션 기능
	@WebInitParam(name="tel", value="010-1111-1111"),
	@WebInitParam(name="email", value="a@mon.com")
}) 


public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 변수 선언
	private String company;
	private String manager;
	private String tel;
	private String email;
	
	public void init() throws ServletException { // 요청은 파라미터 값으로 설정
		// ServletContext
		//company = getServletContext().getInitParameter("company");
		company = "global";
		//manager = getServletContext().getInitParameter("manager");
		manager = "아몬드";
		
		// ServletConfig
		tel = getServletConfig().getInitParameter("tel");
		//tel = "010-1111-1111";
		email = getServletConfig().getInitParameter("email");
		//email = "a@mon.com";
	}

	// doget, dopost 상관없이 사용 가능하도록 설정
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<ul>");
		out.print("<li>회사명:" +company+ "</li>");
		out.print("<li>관리자:" +manager+ "</li>");
		out.print("<li>연락처:" +tel+ "</li>");
		out.print("<li>이메일:" +email+ "</li>");
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
