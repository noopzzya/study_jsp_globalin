package mvcmem.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// mvc.control과 중복으로 사용시 주의
@WebServlet("*.mdo")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd != null) { // cmd(파라미터 값)가 null이 아닐 때
			
			ActionFactory factory = ActionFactory.getInstance();
			Action action = factory.getAction(cmd); // 인덱스가 작성된 로직코드로 처리한 클래스 구현
						
			ActionForward af = action.execute(request, response);
			
			if(af.isRedirect()) { // 결과를 보여줄 페이지로 이동하는 코드
				response.sendRedirect(af.getUrl());
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
				rd.forward(request, response);
			}
			
		}else { // cmd가 null 일 때
			
			// 응답
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			// db 연결 시 예외처리 필수!
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			
			out.println("<h4>올바른 요청 방식이 아닙니다.</h4>");
			out.println("<h4>http://localhost:9090/mvcmem/member.mdo?cmd=요청키워드</h4>");
			
			out.println("</body>");
			out.println("</html>");			
		}
	}

}
