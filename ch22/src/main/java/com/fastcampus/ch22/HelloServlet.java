package com.fastcampus.ch22;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {

	@Override

	public void init() throws ServletException {
		//������ �ʱ�ȭ�ɶ� �ڵ�ȣ�� �Ǵ� �޼ҵ� 
		// 1. ������ �ʱ�ȭ �۾�  ��� 
		System.out.println("[HelloServlet] init() is called ." );
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.�Է�
		//2.ó��
		//3.���
		System.out.println("[HelloServlet] servive() is called. ");
		
	}

	@Override
	public void destroy() {
		System.out.println("[HelloServlet] destroy() is called. ");
	}

	

}
