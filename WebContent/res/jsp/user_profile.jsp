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
  ResultSet rs = Connector.User(request.getParameter("name"));
  
  ResultSetMetaData rsmd = rs.getMetaData();
  int columnsNumber = rsmd.getColumnCount();
  String[] strs = new String[columnsNumber];
  
  while(rs.next()){
 	 for (int i = 1; i <= columnsNumber; i++) {
 	         String columnValue = rs.getString(i);
 	         strs[i-1] = columnValue;	 
 	 }
  }
  %>
  <font color="#1abc9c" class="center">USER PROFILE</font>
  <br>
  <br>
<table style="width:50%">
<tr>
<td><label> Username: </label></td>
<td><%=strs[0]%></td>
</tr>
<tr>
<td><label>Password: </label></td>
<td><%=strs[2] %></td>
</tr>
<tr>
<td><label> Email: </label></td>
<td><%=strs[3]%></td>
</tr>
<tr>
<td><label>Phone number: </label></td>
<td><%=strs[4]%></td>
</tr>
<tr>
<td><label>Role: </label></td>
<td><%=strs[5] %></td>
<td>
<input type="submit" class="buttonNW" value="Confirm"></td>
</tr>
</table>
    
</body>
</html>