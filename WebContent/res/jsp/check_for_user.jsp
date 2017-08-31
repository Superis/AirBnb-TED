<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="javaClasses.mysqlConnector" %>
<%@ page import="javaClasses.Admin" %>
<%@ page import="java.sql.*" %>


<%mysqlConnector Connector = new mysqlConnector();

Connector.establishConnection();
boolean answer = false;

try {
	System.out.println(request.getParameter("q"));
	answer = Connector.searchForUser(request.getParameter("q"));
} catch (SQLException e) {
	e.printStackTrace();
}
if(Admin.check(request.getParameter("q"))) answer = true;
if(answer == true && request.getParameter("func").equals("register")){
	System.out.println("Username in use");
	String res = "<div id='answer' value='no' hidden></div>";
	response.getWriter().write(res);
	%>
	<font color="red">Username in use !</font>
	<%
}
else if(answer == false && request.getParameter("func").equals("login")){
	String res = "<div id='answer' value='no' hidden></div>";
	response.getWriter().write(res);
	%>
	<font color="red">Username doesn't exist! !</font>
	<%
}
else {
	String res = "<div id='answer' value='yes' hidden></div>";
	response.getWriter().write(res);
}

	Connector.destroyConnection();
%>
