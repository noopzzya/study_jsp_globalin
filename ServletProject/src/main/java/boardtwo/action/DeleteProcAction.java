package boardtwo.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.model.BoardDAO;

public class DeleteProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse reponse) throws IOException {		
		
		request.setCharacterEncoding("utf-8"); 

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String pass = request.getParameter("pass");
		
		BoardDAO dbPro = BoardDAO.getInstance();
		int check = dbPro.deleteArticle(num, pass);

		// 해당 뷰에서 사용 할 속성을 저장
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));		
		
		return "/boardtwo/deleteProc.jsp";
	}

}
