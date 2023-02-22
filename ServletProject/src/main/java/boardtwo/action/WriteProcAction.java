package boardtwo.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.model.BoardVO;
import boardtwo.model.BoardDAO;

public class WriteProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse reponse) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// data bean(data 입출력을 위한 데이터 출력) 처리
		BoardVO article = new BoardVO();
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPass(request.getParameter("pass"));
		article.setRegdate(new Timestamp(System.currentTimeMillis()));
		
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setStep(Integer.parseInt(request.getParameter("step")));
		article.setDepth(Integer.parseInt(request.getParameter("depth")));
		article.setContent(request.getParameter("content"));
		article.setIp(request.getRemoteAddr());
		
		// DB연결
		BoardDAO dbPro = BoardDAO.getInstance();
		dbPro.insertArticle(article);
		
		return "/boardtwo/writeProc.jsp";
	}

}
