package com.sample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션은 클래스 위에 있음
//@WebServlet("/MyFirst")
//@WebServlet(name = "MyOne", urlPatterns = {"/xxx", "/yyy", "/zzz"}) // url패턴속성
@WebServlet(name = "MyOne", value = {"/xxx", "/yyy", "/zzz"}) // value
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyFirstServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MyFirstServlet 요청");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
