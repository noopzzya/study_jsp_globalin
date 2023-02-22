package boardtwo.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.model.BoardDAO;
import boardtwo.model.BoardVO;

public class UpdateProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse reponse) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardVO article = new BoardVO();
		
		// dao 순서대로 수정
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		article.setPass(request.getParameter("pass"));
		
		// 성공
		int check = dbPro.updateArticle(article);
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		
		return "/boardtwo/updateProc.jsp";
	}

}
