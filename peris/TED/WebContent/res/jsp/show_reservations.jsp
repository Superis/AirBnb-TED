<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="javaClasses.mysqlConnector" %>
<%@ page import="java.sql.*" %>
 <% 
 
 mysqlConnector Connector = new mysqlConnector();
 Connector.establishConnection();
 ResultSet rs = Connector.searchForReservations((String)request.getSession(false).getAttribute("user"));
 
 ResultSetMetaData rsmd = rs.getMetaData();
 int columnsNumber = rsmd.getColumnCount();
 String[] strs = new String[columnsNumber];
 while(rs.next()){
	 for (int i = 1; i <= columnsNumber; i++) {
	         String columnValue = rs.getString(i);
	         strs[i-1] = columnValue;	 
	 }
 %>
 <%=strs[1]%>
 <%
 } 
 %>

<input type="submit" class="buttonNW" value="Back to search" onclick="show_search()">
</body>
</html>