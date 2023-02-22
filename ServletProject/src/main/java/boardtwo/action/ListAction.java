package boardtwo.action;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.model.*;

// 글목록 처리
public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse reponse) throws IOException {
		
	// 한 페이지에 보여줄 목록 수를 지정
	int pageSize = 5;

	String pageNum = request.getParameter("pageNum");

	// 무엇을 검색할지
	String searchWhat = request.getParameter("searchWhat");
	
	// 검색 할 내용
	String searchText = request.getParameter("searchText");
	
	// 받아온 파라미터값에 한글로 변환처리
	if(searchText != null){
		searchText = new String(searchText.getBytes("utf-8"), "utf-8");
	}
	

	if(pageNum == null){
		pageNum = "1";
	}

	// 현재 페이지
	int currentPage = Integer.parseInt(pageNum);	
	int startRow = (currentPage-1) * pageSize+1;
	int endRow = currentPage * pageSize;
	
	int count = 0;
	int number = 0;
	
	List<BoardVO> articleList = null;
	BoardDAO dbPro = BoardDAO.getInstance();
	count = dbPro.getArticleCount();
	
	if(count > 0){ // 현재 페이지에 해당하는 글 목록
		articleList = dbPro.getArticles(startRow, endRow);
	} else {
		articleList = Collections.emptyList();
	}
	
	/*
	// 검색이 아니면 전체리스트를 보여주고, 검색이면 검색한 내용을 보여줌
	if(searchText == null){
		count = dbPro.getArticleCount(); // 전체 글 수
		
		if(count > 0){
			articleList = dbPro.getArticles(startRow, endRow);
		}
	}else { // 검색일 경우 검색한 내용을 출력	
		count = dbPro.getArticleCount(searchWhat, searchText); // 전체 글 수
		
		if(count > 0){
			articleList = dbPro.getArticles(searchWhat, searchText, startRow, endRow);
		}
	} 
	*/
	
	number = count - (currentPage-1) * pageSize;
	
	// 해당 뷰에서 사용 할 속성
	request.setAttribute("currentPage", new Integer(currentPage));
	request.setAttribute("startRow", new Integer(startRow));
	request.setAttribute("endRow", new Integer(endRow));
	request.setAttribute("count", new Integer(count));
	request.setAttribute("pageSize", new Integer(pageSize));
	request.setAttribute("number", new Integer(number));
	request.setAttribute("articleList", articleList); // articleList 객체
	
	return "/boardtwo/list.jsp";
	
	}

}
