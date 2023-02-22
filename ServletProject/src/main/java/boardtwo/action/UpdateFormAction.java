package boardtwo.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.model.BoardDAO;
import boardtwo.model.BoardVO;

public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse reponse) throws IOException {
	
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		BoardDAO dbPro = BoardDAO.getInstance();
		BoardVO article = dbPro.getArticle(num);

		// 해당 뷰에서 사용 할 속성 저장
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/boardtwo/updateForm.jsp";
	}

}
