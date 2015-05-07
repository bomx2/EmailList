<%@ page import="com.sds.icto.emaillist.vo.EmailListVO"%>
<%@ page import="com.sds.icto.emaillist.dao.EmailListDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	// 이메일을 등록합니다.
	String firstname = request.getParameter("fn");
	String lastname = request.getParameter("ln");
	String email = request.getParameter("email");

	EmailListVO vo = new EmailListVO();
	vo.setFirstname(firstname);
	vo.setLastname(lastname);
	vo.setEmail(email);
	
	EmailListDAO dao = new EmailListDAO();
	dao.insert( vo );

	response.sendRedirect("/Emaillist");
%>