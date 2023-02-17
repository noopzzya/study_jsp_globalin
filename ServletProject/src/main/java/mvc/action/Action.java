package mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.control.ActionForward;

public interface Action {
	
	// 메소드 정의
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
